package geoorg.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class JPAUtil {
    private static Map<String, EntityManagerFactory> persistenceUnits = new HashMap<>();

    @SuppressWarnings("WeakerAccess")
    public static synchronized EntityManager getEntityManager(String persistenceUnitName) {
        persistenceUnits.putIfAbsent(persistenceUnitName,
                Persistence.createEntityManagerFactory(persistenceUnitName));
        return persistenceUnits.get(persistenceUnitName)
                .createEntityManager();
    }

    public static void doWithEntityManager(Consumer<EntityManager> command) {
        EntityManager em = JPAUtil.getEntityManager("utiljpa");
        em.getTransaction().begin();

        command.accept(em);
        if (em.getTransaction().isActive() &&
                !em.getTransaction().getRollbackOnly()) {
            em.getTransaction().commit();
        } else {
            em.getTransaction().rollback();
        }

        em.close();
    }

}
