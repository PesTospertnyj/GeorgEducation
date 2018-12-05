package chapter06.ourexamples.idclass;

import chapter06.ourexamples.embedableid.GlobalGroupId;
import chapter06.ourexamples.embedableid.GlobalStudentGroup;
import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GlobalStudentGroupWithIdClassTest {
    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            GlobalStudentGroupWithIdClass globalStudentGroupWithIdClass = new GlobalStudentGroupWithIdClass("KNU", "E-01", 24);
            session.save(globalStudentGroupWithIdClass);

            transaction.commit();

        }

    }
}