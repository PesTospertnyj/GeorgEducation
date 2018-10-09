package geoorg.sep28streams;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;

/**
 * Created by gd on 9/28/2018.
 */
public class Employee extends Person //implements Comparable<Employee>
{

    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Equals invoked for employee " + o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        return Double.compare(employee.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode invoked for " + this);
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "Employee{" +
                "salary=" + salary +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int compareTo(Employee o) {
        //1
        //return (int) (this.getSalary() - o.getSalary());
        //2
        //return Double.compare(this.getSalary(), o.getSalary());
        //3
        //return new Double(this.getSalary()).compareTo(o.getSalary());
        //4
        final ToDoubleFunction<Employee> salaryExtractor = (Employee e) -> e.getSalary();
        final ToDoubleFunction<Employee> salaryExtractor2 = Employee::getSalary;
        final Comparator<Employee> salaryEmployeeComparator =
                Comparator.comparingDouble(salaryExtractor2).reversed();
        return salaryEmployeeComparator.compare(this, o);
    }
}
