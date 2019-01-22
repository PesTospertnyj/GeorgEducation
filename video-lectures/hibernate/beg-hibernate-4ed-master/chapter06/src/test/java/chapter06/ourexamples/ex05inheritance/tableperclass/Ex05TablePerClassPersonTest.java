package chapter06.ourexamples.ex05inheritance.tableperclass;

import chapter06.ourexamples.ex05inheritance.joinedtable.Ex05JoinedEmployee;
import chapter06.ourexamples.ex05inheritance.joinedtable.Ex05JoinedPerson;
import chapter06.ourexamples.ex05inheritance.joinedtable.Ex05JoinedStudent;
import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by gd on 1/21/2019.
 */
public class Ex05TablePerClassPersonTest {
    @Test
    public void test() {

        Long id = null;

        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Ex05TablePerClassPerson vasya = new Ex05TablePerClassPerson();
            vasya.setName("Vasya");

            Ex05TablePerClassStudent katya = new Ex05TablePerClassStudent();
            katya.setName("Kayta");
            katya.setGroup("MGU-01");

            Ex05TablePerClassEmployee ivanP = new Ex05TablePerClassEmployee();
            ivanP.setName("Ivan Petrovich");
            ivanP.setSalary(1000.0);

            session.save(vasya);
            session.save(katya);
            session.save(ivanP);

            transaction.commit();
        }
    }
}