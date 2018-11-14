package geoorg.nov09excaption;

class NegativeSalaryExcaption extends RuntimeException {
    public NegativeSalaryExcaption() {
        super();
    }

    public NegativeSalaryExcaption(String message) {
        super(message);
    }
}

class MinorExcaption extends IllegalArgumentException {
    public MinorExcaption() {
        super();
    }

    public MinorExcaption(String message) {
        super(message);
    }
}


public class Employee extends Person {
    private double salary;
    private int age;

    @Override
    public void printFIO() throws CannotPrintFioExcaptionbecose {
        System.out.println(getLastName() + " " +getFirstName()+ " " + age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", age=" + age +
                '}';
    }

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0)
            throw new NegativeSalaryExcaption("Salary cannot be negative");
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0)
            throw new IllegalArgumentException("Age cannot be negative");
        if (age < 18) {
            throw new MinorExcaption("Age must be more than 18");
        }
        this.age = age;

    }

}
