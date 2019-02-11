package geoorg;

import geoorg.jpa.util.JPAUtil;
import geoorg.model.Employee;
import org.eclipse.persistence.jpa.jpql.Assert;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void getEntityManager() {
        EntityManager em = JPAUtil.getEntityManager("utiljpa");
        em.close();
    }

    @Test
    public void test() {
        JPAUtil.doWithEntityManager((em) -> {

            final Employee ivan = new Employee();
            ivan.setName("Ivan");

            em.persist(ivan);

            final Query query = em.createQuery("select e from Employee e");
            final List resultList = query.getResultList();
            System.out.println(resultList);

            Assert.isTrue(resultList.size() > 0, "");
        });




    }
}
