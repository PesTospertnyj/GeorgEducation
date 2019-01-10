package chapter06.ourexamples.ex01Basic;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class OrderTest {
    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            Address address = new Address("Pobediteley", "1-a", 23L);
            Order order = new Order(3L, address, "please deliver asap");
            session.save(order);
            transaction.commit();
        }
    }
}