package chapter06.ourexamples.table.generator;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

/**
 * Created by gd on 12/3/2018.
 */
@Entity
public class EmployeeTableGeneator {

    @Id
    @TableGenerator(name = "employee_generator",
            allocationSize = 20
    , initialValue = 10,
    table = "employee_id_table",
    pkColumnName = "id1",
    pkColumnValue = "pkColumnValue",
    valueColumnName = "valueColumnName")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_generator")
    private Long id;
    private String name;

    public EmployeeTableGeneator() {
    }

    public EmployeeTableGeneator(Long id) {
        this.id = id;
    }

    public EmployeeTableGeneator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
