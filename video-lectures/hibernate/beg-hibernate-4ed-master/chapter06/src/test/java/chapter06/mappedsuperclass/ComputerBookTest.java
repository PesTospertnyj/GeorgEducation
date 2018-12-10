package chapter06.mappedsuperclass;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by ggavrysh on 12/10/2018.
 */
public class ComputerBookTest {
    @Test
    public void bookTest() {
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            ComputerBook computerBook = new ComputerBook();
            computerBook.setName("Java");
            computerBook.setLanguage("En");
            session.save(computerBook);
            transaction.commit();
        }
    }
}