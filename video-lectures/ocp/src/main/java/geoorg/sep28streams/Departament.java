package geoorg.sep28streams;

import java.util.List;

/**
 * Created by gd on 9/28/2018.
 */
public class Departament {

    private String name;
    private List<Employee> employees;

    public Departament(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departament that = (Departament) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return employees != null ? employees.equals(that.employees) : that.employees == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
