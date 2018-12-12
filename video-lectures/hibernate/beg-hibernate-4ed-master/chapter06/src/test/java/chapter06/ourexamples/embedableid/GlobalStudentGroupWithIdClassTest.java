package chapter06.ourexamples.embedableid;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.io.Serializable;

public class GlobalStudentGroupWithIdClassTest {
    @Test
    public void test() {
        Serializable id;
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            GlobalGroupId globalGroupId = new GlobalGroupId("MGU", "M-01");
            GlobalStudentGroup globalStudentGroup = new GlobalStudentGroup(globalGroupId, 12);

            Example example = new Example();
            example.setGlobalStudentGroup(globalStudentGroup);

            session.save(globalStudentGroup);
            id = session.save(example);

            transaction.commit();

        }

        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();

            Example load = session.load(Example.class, id);

            load.getGlobalStudentGroup();
            transaction.commit();

        }

    }
}