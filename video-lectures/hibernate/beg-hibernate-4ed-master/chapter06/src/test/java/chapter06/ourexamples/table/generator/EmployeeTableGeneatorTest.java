package chapter06.ourexamples.table.generator;

import chapter06.twotables.Customer;
import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by gd on 12/7/2018.
 */
public class EmployeeTableGeneatorTest {

    @Test
    public void test() {
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            EmployeeTableGeneator employeeTableGeneator = new EmployeeTableGeneator("John");

            session.save(employeeTableGeneator);

            employeeTableGeneator = new EmployeeTableGeneator("Mary");
            session.save(employeeTableGeneator);

            employeeTableGeneator = new EmployeeTableGeneator("Bob");
            session.save(employeeTableGeneator);

            employeeTableGeneator = new EmployeeTableGeneator("Tom");
            session.save(employeeTableGeneator);

            employeeTableGeneator = new EmployeeTableGeneator("Vova");
            session.save(employeeTableGeneator);

            transaction.commit();
        }
    }
}