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

            final Employee john = new Employee();
            john.setEmployeeName("John");

            final Employee bob = new Employee();
            bob.setEmployeeName("Bob");

            final Employee alice = new Employee();
            alice.setEmployeeName("Alice");

            final Employee jane = new Employee();
            alice.setEmployeeName("Jane");

            final Department department = new Department();
            department.setName("IT");
            department.setEmployees(new ArrayList<>(Arrays.asList(john, alice, bob )));

            john.setDepartment(department);
            bob.setDepartment(department);
            alice.setDepartment(department);

            final Department departmentGlobal = new Department();
            departmentGlobal.setName("Minsk");
            departmentGlobal.setGlobalEmployees(Arrays.asList(jane));

//            session.save(john);
//            session.save(bob);

            session.save(department);
            session.save(departmentGlobal);

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