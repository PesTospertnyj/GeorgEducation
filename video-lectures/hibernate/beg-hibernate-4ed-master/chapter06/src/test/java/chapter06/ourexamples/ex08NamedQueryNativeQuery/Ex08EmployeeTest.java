package chapter06.ourexamples.ex08NamedQueryNativeQuery;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by gd on 1/29/2019.
 */
public class Ex08EmployeeTest {
    @Test
    public void test() {

        try (Session session = SessionUtil.getSession()) {

            final Transaction transaction = session.beginTransaction();
            final EntityManager entityManager = (EntityManager) session;

            Ex08Employee john = new Ex08Employee();
            john.setId(1L);
            john.setName("John");
            john.setSalary(1000.0);

            Ex08Employee alice = new Ex08Employee();
            alice.setId(2L);
            alice.setName("Alice");
            alice.setSalary(800.0);

            Ex08Employee lead = new Ex08Employee();
            lead.setId(3L);
            lead.setName("Boss");
            lead.setSalary(1200.0);

            entityManager.persist(john);
            entityManager.persist(alice);
            entityManager.persist(lead);

            transaction.commit();
        }


        try (Session session = SessionUtil.getSession()) {

            final EntityManager entityManager = (EntityManager) session;

//            org.hibernate.query.Query query2 = session.getNamedQuery("FIND_EMPLOYEE_BY_NAME2");
//            query2.setParameter("name_param", "Alice");
//            Object alice = query2.getSingleResult();
//            System.out.println(alice);

            TypedQuery<Ex08Employee> query1 = entityManager.createNamedQuery("FIND_EMPLOYEE_BY_NAME", Ex08Employee.class);
            query1.setParameter("name_param", "John");

            Ex08Employee john = query1.getSingleResult();
            System.out.println(john);

            query1.setParameter("name_param", "Alice");
            Ex08Employee alice2 = query1.getSingleResult();
            System.out.println(alice2);

        }
    }

    @Test
    public void testNativeQuery() {

        try (Session session = SessionUtil.getSession()) {
            final NativeQuery nativeQuery = session.getNamedNativeQuery("NATIVE_EMP_BY_SALARY_RANGE");
            nativeQuery.setParameter("lower_bound", 900.0);
            nativeQuery.setParameter("higher_bound", 1300.0);
            List resultList = nativeQuery.getResultList();
            System.out.println("empoyees: " + resultList);
        }
    }
}