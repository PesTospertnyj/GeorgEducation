package chapter06.ourexamples.ex04elementCollection;

import chapter06.ourexamples.ex03many2many.Course;
import chapter06.ourexamples.ex03many2many.Student;
import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.testng.Assert.*;

public class Ex04EmployeeTest {
    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();

            Ex04Employee vasya = new Ex04Employee();
            vasya.setName("Vasya");
            vasya.setPhones(Arrays.asList("01", "+3752912312312"));

            session.save(vasya);

            transaction.commit();
        }
    }
}