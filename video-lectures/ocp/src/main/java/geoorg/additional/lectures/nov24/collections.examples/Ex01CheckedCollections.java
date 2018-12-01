package geoorg.additional.lectures.nov24.collections.examples;

import java.util.*;

/**
 * Created by gd on 12/1/2018.
 */
public class Ex01CheckedCollections {
    public static void main(String ... args) {
        Comparator<Employee> ascendingSalaryComparator =
                (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName());
        NavigableMap<Employee, Double> employeesSalaryMap = new TreeMap<>();
//        employeesSalaryMap.put(new Employee(1L, "John"), 1000.0);
//        employeesSalaryMap.put(new Employee(2L, "Mary"), 900.0);

        NavigableMap<Employee, Double> checkedSalaryMap = Collections.checkedNavigableMap(employeesSalaryMap, Employee.class, Double.class);

        Map rawMap = employeesSalaryMap;
        rawMap.put(new Integer(1), new Double(23));
        rawMap.put(new Integer(10), new Double(25));
//        rawMap.put(new Employee(1L, "John"), 1000.0);

        rawMap = checkedSalaryMap;
        //rawMap.put(new Integer(1), new Double(23));//Exception in thread "main" java.lang.ClassCastException: Attempt to insert class java.lang.Integer key into map with key type class geoorg.additional.lectures.nov24.collections.examples.Employee
    }
}
