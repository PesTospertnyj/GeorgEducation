package chapter10.our;

import chapter10.model.Product;
import chapter10.model.Software;
import chapter10.model.Software_;
import chapter10.model.Supplier;
import chapter10.our.Utils;
import com.autumncode.jpa.util.JPASessionUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.function.Consumer;

import static chapter10.our.Utils.doWithEntityManager;

/**
 * Created by ggavrysh on 2019-02-11.
 */
public class StaticMetaDataTests {
    //    @BeforeMethod
    public void populateData() {
        Utils.fillData();
    }

    //    @AfterMethod
    public void cleanup() {
        Utils.cleanData();
    }

    ////////////////////////our examples BEGIN

    @Test
    public void testGetSoftwareByName() {
        doWithEntityManager((em) -> {
            final CriteriaBuilder cb = em.getCriteriaBuilder();

            final CriteriaQuery<Software> criteriaQuery = cb.createQuery(Software.class);
            final Root<Software> softwareRoot = criteriaQuery.from(Software.class);
            criteriaQuery.select(softwareRoot);
            criteriaQuery.where(cb.equal(softwareRoot.get(Software_.name), "SuperDetect"));


            final TypedQuery<Software> typedQuery = em.createQuery(criteriaQuery);
            final List<Software> resultList = typedQuery.getResultList();
            System.out.println(resultList);

            Assert.assertEquals(resultList.size(), 1);
        });
    }
}
