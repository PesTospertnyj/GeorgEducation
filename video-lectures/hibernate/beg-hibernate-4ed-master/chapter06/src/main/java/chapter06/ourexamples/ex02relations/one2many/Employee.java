package chapter06.ourexamples.ex02relations.one2many;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
//@Builder
public class Employee {

    public Employee() {
    }

    @Id
    @SequenceGenerator(name = "employee_generator", sequenceName = "seq_departments", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    private Long id;

    private String name;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Department department;
}
