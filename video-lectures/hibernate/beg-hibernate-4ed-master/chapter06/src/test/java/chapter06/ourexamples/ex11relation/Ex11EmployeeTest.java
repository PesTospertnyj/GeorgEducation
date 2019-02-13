package chapter06.ourexamples.ex11relation;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggavrysh on 2019-02-12.
 */
public class Ex11EmployeeTest {
    @Test
    public void test() {
        List<Long> ids = new ArrayList<>();
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            final Ex11Employee john = Ex11Employee.builder()
                    .name("John")
                    .build();

            final Ex11EmployeeHistory history = Ex11EmployeeHistory.builder()
                    .record("Good worker")
                    .employee(john)
                    .build();

            session.persist(john);
            session.persist(history);

            transaction.commit();

            ids.add(john.getId());
            ids.add(history.getId());

        }

        try (Session session = SessionUtil.getSession()) {
            final Ex11Employee john = session.find(Ex11Employee.class, ids.get(0));
            System.out.println(john);

            final Ex11EmployeeHistory history = session.find(Ex11EmployeeHistory.class, ids.get(1));
            System.out.println(history);

        }
    }
}