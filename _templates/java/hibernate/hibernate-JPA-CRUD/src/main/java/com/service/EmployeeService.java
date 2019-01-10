package com.service;

import com.model.Employee;
import com.util.JPAUtility;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeService implements Crud<Employee> {

    public Employee create(Employee emp) {
        EntityManager manager = JPAUtility.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(emp);
        manager.getTransaction().commit();
        manager.close();
        return emp;
    }

    public List<Employee> getAll() {
        EntityManager manager = JPAUtility.getEntityManager();
//      JPQL query
        TypedQuery<Employee> namedQuery = manager.createQuery("FROM Employee", Employee.class);
//        Example of JPQL named query (instead the previous line)
//        TypedQuery<Employee> namedQuery = manager.createNamedQuery("getAll", Employee.class);
        List<Employee> list = namedQuery.getResultList();
        manager.close();
        return list;
    }

    @Override
    public Employee read(Object obj) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        Employee emp = null;
        if (obj instanceof Integer) {
            emp = entityManager.find(Employee.class, obj);
        }
        return emp;
    }

    @Override
    public Employee update(Employee employee) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        Employee emp = entityManager.find(Employee.class, employee.getId());
        if (emp != null) {
            entityManager.getTransaction().begin();
            emp.setName(employee.getName());
            emp.setLastName(employee.getLastName());
            emp.setAge(employee.getAge());
            entityManager.getTransaction().commit();
            emp = entityManager.find(Employee.class, employee.getId());
        }
        entityManager.close();
        return emp;
    }

    @Override
    public void remove(Employee employee) {
        EntityManager entityManager = JPAUtility.getEntityManager();
        Employee emp = entityManager.find(Employee.class, employee.getId());
        if (emp != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(emp);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }
}
