package chapter06.ourexamples.ex05inheritance;

import chapter06.ourexamples.ex05inheritance.singletable.Ex05Employee;
import chapter06.ourexamples.ex05inheritance.singletable.Ex05Person;
import chapter06.ourexamples.ex05inheritance.singletable.Ex05Student;
import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

/**
 * Created by gd on 1/21/2019.
 */
public class Ex05SingleTableInheritanceTest {
    @Test
    public void test() {

        Long id = null;

        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Ex05Person vasya = new Ex05Person();
            vasya.setName("Vasya");

            Ex05Student katya = new Ex05Student();
            katya.setName("Kayta");
            katya.setGroup("MGU-01");

            Ex05Employee ivanP = new Ex05Employee();
            ivanP.setName("Kayta");
            ivanP.setSalary(1000.0);

            session.save(vasya);
            session.save(katya);
            session.save(ivanP);

            transaction.commit();
        }
    }
}