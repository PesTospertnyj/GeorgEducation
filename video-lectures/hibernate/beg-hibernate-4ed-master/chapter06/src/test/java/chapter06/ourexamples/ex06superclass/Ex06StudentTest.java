package chapter06.ourexamples.ex06superclass;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by gd on 1/23/2019.
 */
public class Ex06StudentTest {
    @Test
    public void test() {

        Long id = null;

        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();

            Ex06Student vasya = new Ex06Student();
            vasya.setName("Vasya");
            vasya.setPhone("101");

            session.save(vasya);
            transaction.commit();
        }
    }
}