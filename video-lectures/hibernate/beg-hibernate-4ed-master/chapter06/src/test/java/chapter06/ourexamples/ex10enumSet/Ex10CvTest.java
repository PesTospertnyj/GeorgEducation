package chapter06.ourexamples.ex10enumSet;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by ggavrysh on 2019-01-31.
 */
public class Ex10CvTest {
    @Test
    public void test() {

        try (Session session = SessionUtil.getSession()) {

            final Transaction transaction = session.beginTransaction();

            final Ex10Cv cv = new Ex10Cv();
            cv.setTitle("dream team is loooking for a job");
            cv.setPreferredType(Ex10WorkTypeEnum.REMOTE);
            cv.setWorkTypes(new HashSet<Ex10WorkTypeEnum>
                    (Arrays.asList(Ex10WorkTypeEnum.FULL_TIME, Ex10WorkTypeEnum.PART_TIME)));

            session.save(cv);
            transaction.commit();

        }
    }
}