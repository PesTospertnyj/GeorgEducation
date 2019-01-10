package chapter06.ourexamples.ex01Basic;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class OrderItemTest {
    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            OrderItem orderItem = OrderItem.builder()
                    .id(1L)
                    .comment("please deliver asap123")
                    .name("phone")
                    .price(new BigDecimal(111.0000001))
                    .quantity(4)
                    .build();

//            orderItem.setQuantity(12);
            session.save(orderItem);
            transaction.commit();

        }

//        try (Session session = SessionUtil.getSession()) {
//            final Transaction transaction = session.beginTransaction();
//            OrderItem orderItem = session.load(OrderItem.class, 2L);
//            System.out.println(orderItem);
//            transaction.commit();
//
//        }

        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            OrderItem orderItem = session.load(OrderItem.class, 1L);
            orderItem.setQuantity(20);
            orderItem.setName("iphone");
            System.out.println(orderItem);
            transaction.commit();

        }
    }
}