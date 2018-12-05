package chapter06.ourexamples.idembedable;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

/**
 * Created by gd on 12/5/2018.
 */
public class GlobalStudentGroupWithIdClass2Test {

    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            EmbedableGlobalGroupId embedableGlobalGroupId = new EmbedableGlobalGroupId("BGU", "I-01");
            GlobalStudentGroup2 globalStudentGroup2 = new GlobalStudentGroup2(embedableGlobalGroupId, 30);

            session.save(globalStudentGroup2);
            transaction.commit();
        }
    }

}