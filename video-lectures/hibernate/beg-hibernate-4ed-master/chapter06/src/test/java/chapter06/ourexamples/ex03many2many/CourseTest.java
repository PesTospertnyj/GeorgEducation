package chapter06.ourexamples.ex03many2many;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.testng.Assert.*;

public class CourseTest {
    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            Student ivan = new Student();
            ivan.setName("Ivan");

            Student kolya = new Student();
            kolya.setName("Kolya");

            Student lena = new Student();
            lena.setName("Lena");

            Student masha = new Student();
            masha.setName("Masha");

            Course math = new Course();
            math.setName("Math");

            Course phys = new Course();
            phys.setName("phys");

            ivan.setCourses(Arrays.asList(math));

            kolya.setCourses(Arrays.asList(math, phys));

            lena.setCourses(Arrays.asList( phys));

            math.setStudents(new HashSet<>(Arrays.asList(masha)));

            session.save(ivan);
            session.save(kolya);
            session.save(lena);
            transaction.commit();
        }
    }
}