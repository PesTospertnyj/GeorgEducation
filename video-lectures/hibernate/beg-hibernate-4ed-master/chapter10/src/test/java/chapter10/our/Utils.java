package chapter10.our;

import chapter10.model.Product;
import chapter10.model.Software;
import chapter10.model.Supplier;
import com.autumncode.jpa.util.JPASessionUtil;

import javax.persistence.EntityManager;
import java.util.function.Consumer;

/**
 * Created by ggavrysh on 2019-02-11.
 */
public class Utils {
    public static void doWithEntityManager(Consumer<EntityManager> command) {
        EntityManager em = JPASessionUtil.getEntityManager("chapter10");
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

    public static void fillData() {
        doWithEntityManager((em) -> {
            Supplier supplier = new Supplier("Hardware, Inc.");
            supplier.getProducts().add(
                    new Product(supplier, "Optical Wheel Mouse", "Mouse", 5.00));
            supplier.getProducts().add(
                    new Product(supplier, "Trackball Mouse", "Mouse", 22.00));
            em.persist(supplier);

            supplier = new Supplier("Hardware Are We");
            supplier.getProducts().add(
                    new Software(supplier, "SuperDetect", "Antivirus", 14.95, "1.0"));
            supplier.getProducts().add(
                    new Software(supplier, "Wildcat", "Browser", 19.95, "2.2"));
            supplier.getProducts().add(
                    new Product(supplier, "AxeGrinder", "Gaming Mouse", 42.00));
            supplier.getProducts().add(
                    new Product(supplier, "I5 Tablet", "Computer", 849.99));
            supplier.getProducts().add(
                    new Product(supplier, "I7 Desktop", "Computer", 1599.99));

            em.persist(supplier);
        });
    }

    public static void cleanData() {
        doWithEntityManager((em) -> {
            em.createQuery("delete from Software").executeUpdate();
            em.createQuery("delete from Product").executeUpdate();
            em.createQuery("delete from Supplier").executeUpdate();
        });
    }
}
