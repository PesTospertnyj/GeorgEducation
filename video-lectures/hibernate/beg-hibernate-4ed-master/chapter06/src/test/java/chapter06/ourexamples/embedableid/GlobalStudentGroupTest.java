package chapter06.ourexamples.embedableid;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by gd on 12/5/2018.
 */
public class GlobalStudentGroupTest {

    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            GlobalGroupId globalGroupId = new GlobalGroupId("BGU", "I-01");
            GlobalStudentGroup globalStudentGroup = new GlobalStudentGroup(globalGroupId, 30);

            session.save(globalStudentGroup);
            transaction.commit();
        }
    }

}