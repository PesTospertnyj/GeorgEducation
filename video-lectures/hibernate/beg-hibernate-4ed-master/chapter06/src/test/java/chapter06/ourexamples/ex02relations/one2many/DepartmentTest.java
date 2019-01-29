package chapter06.ourexamples.ex02relations.one2many;

import com.autumncode.hibernate.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DepartmentTest {
    @Test
    public void test() {
        Long depId = null;
        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();

            final Ex02Employee john = new Ex02Employee();
            john.setEmployeeName("John");

            final Ex02Employee bob = new Ex02Employee();
            bob.setEmployeeName("Bob");

            final Ex02Employee alice = new Ex02Employee();
            alice.setEmployeeName("Alice");

            final Ex02Employee jane = new Ex02Employee();
            jane.setEmployeeName("Jane");

            final Ex02Department ex02Department = new Ex02Department();
            ex02Department.setName("IT");
            ex02Department.setEx02Employees(new ArrayList<>(Arrays.asList(john, alice, bob )));

            john.setEx02Department(ex02Department);
            bob.setEx02Department(ex02Department);
            alice.setEx02Department(ex02Department);

            final Ex02Department ex02DepartmentGlobal = new Ex02Department();
            ex02DepartmentGlobal.setName("Minsk");
            ex02DepartmentGlobal.setGlobalEx02Employees(Arrays.asList(jane));

//            session.save(john);
//            session.save(bob);

            session.save(ex02Department);
            session.save(ex02DepartmentGlobal);

            depId = ex02Department.getId();

            transaction.commit();
        }

        try (Session session = SessionUtil.getSession()) {
            final Transaction transaction = session.beginTransaction();
            final Ex02Department ex02Department = session.load(Ex02Department.class, depId);
            List<Ex02Employee> ex02Employees = ex02Department.getEx02Employees();
            System.out.println("before shuffle employees: " + ex02Employees);
            Collections.shuffle(ex02Employees);
            System.out.println("after shuffle employees: " + ex02Employees);
//            department.setEx02Employees(ex02Employees);
            transaction.commit();
        }
    }
}