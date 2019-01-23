package chapter06.ourexamples.idclass;

import chapter06.ourexamples.embedableid.GlobalGroupId;
import chapter06.ourexamples.embedableid.GlobalStudentGroup;
import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class GlobalStudentGroupWithIdClassTest {
    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            GlobalStudentGroupWithIdClass globalStudentGroupWithIdClass = new GlobalStudentGroupWithIdClass("KNU", "E-01", 24);

            globalStudentGroupWithIdClass.setPrices(Arrays.asList(10, 50, 70));
            session.save(globalStudentGroupWithIdClass);

            transaction.commit();

        }

        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();

            GlobalGroupIdClass globalGroupIdClass = new GlobalGroupIdClass("KNU", "E-01");
            GlobalStudentGroupWithIdClass globalStudentGroupWithIdClass
                    = session.get(GlobalStudentGroupWithIdClass.class, globalGroupIdClass);

            System.out.println(globalStudentGroupWithIdClass);

            transaction.commit();

        }

    }
}