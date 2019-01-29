package chapter06.ourexamples.ex07temporal;

import chapter06.ourexamples.ex06superclass.Ex06Student;
import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by gd on 1/29/2019.
 */
public class Ex07EmployeeTest {
    @Test
    public void test() {

        Long id = null;

        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();

            Ex07Employee vasya = new Ex07Employee();
            vasya.setId(new Long(1));
            transaction.commit();
        }
    }
}