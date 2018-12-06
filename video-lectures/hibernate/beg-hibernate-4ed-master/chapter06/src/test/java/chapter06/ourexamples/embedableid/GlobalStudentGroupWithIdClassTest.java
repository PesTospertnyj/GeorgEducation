package chapter06.ourexamples.embedableid;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

public class GlobalStudentGroupWithIdClassTest {
    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            GlobalGroupId globalGroupId = new GlobalGroupId("MGU", "M-01");
            GlobalStudentGroup globalStudentGroup = new GlobalStudentGroup(globalGroupId, 12);

            session.save(globalStudentGroup);

            transaction.commit();

        }

    }
}