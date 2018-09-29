package geoorg.sep28streams;

/**
 * Created by gd on 9/28/2018.
 */
public class Employee extends Person {

    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Employee employee = (Employee) o;

        return Double.compare(employee.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
