package chapter06.ourexamples;

import javax.persistence.*;

/**
 * Created by gd on 12/3/2018.
 */
@Entity
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_generator", sequenceName = "seq_employee", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    private Long id;
}
