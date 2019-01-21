package chapter06.ourexamples.ex05inheritance.joinedtable;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by gd on 1/21/2019.
 */
public class Ex05JoinedPersonTest {
    @Test
    public void test() {

        Long id = null;

        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Ex05JoinedPerson vasya = new Ex05JoinedPerson();
            vasya.setName("Vasya");

            Ex05JoinedStudent katya = new Ex05JoinedStudent();
            katya.setName("Kayta");
            katya.setGroup("MGU-01");

            Ex05JoinedEmployee ivanP = new Ex05JoinedEmployee();
            ivanP.setName("Ivan Petrovich");
            ivanP.setSalary(1000.0);

            session.save(vasya);
            session.save(katya);
            session.save(ivanP);

            transaction.commit();
        }
    }
}