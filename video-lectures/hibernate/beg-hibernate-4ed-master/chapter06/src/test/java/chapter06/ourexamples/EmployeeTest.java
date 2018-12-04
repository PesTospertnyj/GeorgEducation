package chapter06.ourexamples;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by gd on 12/3/2018.
 */
public class EmployeeTest {

    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            assertNotNull(session);
            Transaction transaction = session.beginTransaction();
            Employee employee = new Employee();
            session.save(employee);
            employee = new Employee();
            session.save(employee);
            employee = new Employee();
            session.save(employee);
            employee = new Employee();
            session.save(employee);
            employee = new Employee();
            session.save(employee);
            employee = new Employee();
            session.save(employee);
            employee = new Employee();
            session.save(employee);

            transaction.commit();
        }
    }

}