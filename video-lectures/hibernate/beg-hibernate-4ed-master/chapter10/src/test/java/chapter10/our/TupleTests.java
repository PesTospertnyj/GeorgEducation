package chapter10.our;

import chapter10.model.Software;
import chapter10.model.Software_;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static chapter10.our.Utils.doWithEntityManager;

/**
 * Created by ggavrysh on 2019-02-11.
 */
public class TupleTests {
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
    public void test() {
        doWithEntityManager((em) -> {
            final CriteriaBuilder cb = em.getCriteriaBuilder();

            final CriteriaQuery<Tuple> tupleQuery = cb.createTupleQuery();
            final Root<Software> softwareRoot = tupleQuery.from(Software.class);
             tupleQuery.select(cb.tuple(softwareRoot.get(Software_.name),
                     softwareRoot.get(Software_.version)));

            final TypedQuery<Tuple> typedQuery = em.createQuery(tupleQuery);
            final List<Tuple> resultList = typedQuery.getResultList();
            System.out.println(resultList);



        });
    }

    @Test
    public void test2() {
        doWithEntityManager((em) -> {
            final CriteriaBuilder cb = em.getCriteriaBuilder();

            final CriteriaQuery<Object> criteriaQuery = cb.createQuery();
            final Root<Software> softwareRoot = criteriaQuery.from(Software.class);
            criteriaQuery.multiselect(softwareRoot.get(Software_.name),
                    softwareRoot.get(Software_.version));

            final TypedQuery<Object> query = em.createQuery(criteriaQuery);
            final List<Object> resultList = query.getResultList();
            System.out.println(resultList);



        });
    }


}
