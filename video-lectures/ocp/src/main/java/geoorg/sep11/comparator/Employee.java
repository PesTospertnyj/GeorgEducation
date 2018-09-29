package geoorg.sep11.comparator;

import java.util.Comparator;

/**
 * Created by gd on 9/11/2018.
 */
public class Employee implements Comparable<Employee>, Comparator<Employee> {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        return age - o.age;
    }

    public static void main(String[] args) {
        Comparable<Employee> employeeComparable = (emp) -> {
            return 0;
        };
        Employee employee = (Employee)
         employeeComparable;
        Comparator<Employee> employeeComparator = (e1, e2) -> {
            return -1;
        };
     }

    @Override
    public int compare(Employee o1, Employee o2) {
        return 0;
    }
}
