package chapter10;

import chapter10.model.Product;
import chapter10.model.Software;
import chapter10.model.Supplier;
import com.autumncode.jpa.util.JPASessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.testng.Assert.assertEquals;

/**
 * Created by gd on 2/11/2019.
 */
public class OurQueryTest {

    private void doWithEntityManager(Consumer<EntityManager> command) {
        EntityManager em = JPASessionUtil.getEntityManager("chapter10");
        em.getTransaction().begin();

        command.accept(em);
        if (em.getTransaction().isActive() &&
                !em.getTransaction().getRollbackOnly()) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
        }

        em.close();
    }

//        @BeforeMethod
    public void populateData() {
        doWithEntityManager((em) -> {
            Supplier supplier = new Supplier("Hardware, Inc.");
            supplier.getProducts().add(
                    new Product(supplier, "Optical Wheel Mouse", "Mouse", 5.00));
            supplier.getProducts().add(
                    new Product(supplier, "Trackball Mouse", "Mouse", 22.00));
            em.persist(supplier);

            supplier = new Supplier("Hardware Are We");
            supplier.getProducts().add(
                    new Software(supplier, "SuperDetect", "Antivirus", 14.95, "1.0"));
            supplier.getProducts().add(
                    new Software(supplier, "Wildcat", "Browser", 19.95, "2.2"));
            supplier.getProducts().add(
                    new Product(supplier, "AxeGrinder", "Gaming Mouse", 42.00));
            supplier.getProducts().add(
                    new Product(supplier, "I5 Tablet", "Computer", 849.99));
            supplier.getProducts().add(
                    new Product(supplier, "I7 Desktop", "Computer", 1599.99));

            em.persist(supplier);
        });
    }

    //    @AfterMethod
    public void cleanup() {
        doWithEntityManager((em) -> {
            em.createQuery("delete from Software").executeUpdate();
            em.createQuery("delete from Product").executeUpdate();
            em.createQuery("delete from Supplier").executeUpdate();
        });
    }

    ////////////////////////our examples BEGIN

    @Test
    public void testEntityType() {
        doWithEntityManager((em) -> {
            final Metamodel metamodel = em.getMetamodel();
            EntityType<Product> productEntityType = metamodel.entity(Product.class);
            Ch10Utils.listAttributes(productEntityType);
        });
    }



    @Test
    public void testStrongType() {
        doWithEntityManager((em) -> {
            final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            final CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
            final Root<Product> productRoot = criteriaQuery.from(Product.class);
            final EntityType<Product> product_ = productRoot.getModel();
            final SingularAttribute<? super Product, String> singularAttribute = product_.getSingularAttribute("name", String.class);
            criteriaQuery.select(productRoot.get(singularAttribute));

            final List<Object> resultList = em.createQuery(criteriaQuery).getResultList();
            System.out.println(resultList);
        });
    }


    @Test
    public void testGetAllSoftware() {
        doWithEntityManager((em) -> {
            final CriteriaBuilder cb = em.getCriteriaBuilder();
            final CriteriaQuery<Software> criteriaQuery = cb.createQuery(Software.class);
            final Root<Software> softwareRoot = criteriaQuery.from(Software.class);
            criteriaQuery.select(softwareRoot);

            final TypedQuery<Software> typedQuery = em.createQuery(criteriaQuery);
            final List<Software> resultList = typedQuery.getResultList();
            System.out.println(resultList);

            Assert.assertEquals(resultList.size(), 2);
        });
    }

    @Test
    public void testGetSupplierByName() {
        doWithEntityManager((em) -> {
            final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            final CriteriaQuery<Supplier> criteriaQuery = criteriaBuilder.createQuery(Supplier.class);
            final Root<Supplier> supplierRoot = criteriaQuery.from(Supplier.class);
            criteriaQuery.select(supplierRoot);
            criteriaQuery.where(criteriaBuilder.equal(
                    supplierRoot.get("name"),
                    criteriaBuilder.parameter(String.class, "param_name")));

            final TypedQuery<Supplier> supplierTypedQuery = em.createQuery(criteriaQuery).setParameter("param_name", "Hardware, Inc.");
            final List<Supplier> supplierList = supplierTypedQuery.getResultList();
            System.out.println(supplierList);

            Assert.assertEquals(supplierList.size(), 1);

        });
    }

    @Test
    public void testGetSupplierByNameLiteral() {
        doWithEntityManager((em) -> {
            final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            final CriteriaQuery<Supplier> criteriaQuery = criteriaBuilder.createQuery(Supplier.class);
            final Root<Supplier> supplierRoot = criteriaQuery.from(Supplier.class);
            criteriaQuery.select(supplierRoot);
            criteriaQuery.where(criteriaBuilder.equal(
                    supplierRoot.get("name"),
                    "Hardware, Inc."));

            final TypedQuery<Supplier> supplierTypedQuery = em.createQuery(criteriaQuery);
            final List<Supplier> supplierList = supplierTypedQuery.getResultList();
            System.out.println(supplierList);

            Assert.assertEquals(supplierList.size(), 1);
        });
    }

    /**
     * find product by product name and supplier name
     */
    @Test
    public void testDynamicQuery() {
        final String productNameSubstr = "Wildcat";
        final String supplierNameSubstr = "Hardware Are We";

        doWithEntityManager((em) -> {
            final CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            final CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
            final Root<Product> productRoot = criteriaQuery.from(Product.class);
            criteriaQuery.select(productRoot);

            List<Predicate> criteria = new ArrayList<>();

            if (StringUtils.isNotBlank(supplierNameSubstr)) {
                final Join<Product, Supplier> supplierJoin = productRoot.join("supplier");

                final ParameterExpression<String> supplierNameParam =
                        criteriaBuilder.parameter(String.class, "suppl_name");
                criteria.add(criteriaBuilder.like(supplierJoin.get("supplierName"), supplierNameParam));
            }

            if (StringUtils.isNotBlank(productNameSubstr)) {
                final Predicate productNamePredicate = criteriaBuilder
                        .equal(productRoot.get("name"), productNameSubstr);

                criteria.add(productNamePredicate);
            }

            if (criteria.size() == 0) {
                throw new RuntimeException();
            } else if (criteria.size() == 1) {
                criteriaQuery.where(criteria.get(0));
            } else {
                criteriaQuery.where(criteriaBuilder.and(criteria.toArray(new Predicate[criteria.size()])));
            }

            final TypedQuery<Product> query = em.createQuery(criteriaQuery);
            if (StringUtils.isNotBlank(supplierNameSubstr)) {
                query.setParameter("suppl_name", supplierNameSubstr);
            }

            final List<Product> resultList = query.getResultList();
            System.out.println(resultList.size());
            System.out.println(resultList);
        });
    }

    @Test
    public void test() {
        doWithEntityManager((em) -> {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
            Root<Product> root = criteria.from(Product.class);
            criteria.select(root);

            assertEquals(em.createQuery(criteria).getResultList().size(), 7);
        });
    }

    /////////////////   END

}
