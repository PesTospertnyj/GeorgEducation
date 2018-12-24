package chapter06.ourexamples.ex02relations.one2many;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class DepartmentTest {
    @Test
    public void test() {
        Long depId = null;
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();

            final Employee employee1 = new Employee();
            employee1.setName("John");

            final Employee employee2 = new Employee();
            employee2.setName("Bob");

            final Employee employee3 = new Employee();
            employee3.setName("Alice");

            final Department department = new Department();
            department.setName("IT");
            department.setEmployees(new ArrayList<>(Arrays.asList(employee1, employee2, employee3 )));

            employee1.setDepartment(department);
            employee2.setDepartment(department);
            employee3.setDepartment(department);

//            session.save(employee1);
//            session.save(employee2);

            session.save(department);

            depId = department.getId();

            transaction.commit();
        }

        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            final Department department = session.load(Department.class, depId);
            List<Employee> employees = department.getEmployees();
            Collections.shuffle(employees);
//            System.out.println(employees);
//            department.setEmployees(employees);
            transaction.commit();
        }
    }
}