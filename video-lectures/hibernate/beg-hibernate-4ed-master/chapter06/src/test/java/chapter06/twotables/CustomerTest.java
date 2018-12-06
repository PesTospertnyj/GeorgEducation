package chapter06.twotables;

import chapter06.ourexamples.Employee;
import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by gd on 12/6/2018.
 */
public class CustomerTest {

    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            final Customer customer = new Customer(1, "John", "Munich");

            session.save(customer);

            transaction.commit();
        }
    }

}