package chapter06.ourexamples.ex09immutable;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;

import static org.testng.Assert.*;

/**
 * Created by gd on 1/30/2019.
 */
public class Ex09GenderTest {
    @Test
    public void test() {

        Long id = null;
        try (Session session = SessionUtil.getSession()) {

            EntityManager entityManager = (EntityManager) session;

            entityManager.getTransaction().begin();

            Ex09Gender gender = new Ex09Gender();
            gender.setName("male");
            gender.setId(1L);

            entityManager.persist(gender);
            id = gender.getId();

            entityManager.getTransaction().commit();
        }

        try (Session session = SessionUtil.getSession()) {

            EntityManager entityManager = (EntityManager) session;

            entityManager.getTransaction().begin();

            Ex09Gender gender = entityManager.find(Ex09Gender.class, id);
            gender.setName("UpdatedMale");

            entityManager.getTransaction().commit();
        }

        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();

            Ex09Gender gender = session.load(Ex09Gender.class, id);
            gender.setName("female");

            transaction.commit();
        }
    }
}