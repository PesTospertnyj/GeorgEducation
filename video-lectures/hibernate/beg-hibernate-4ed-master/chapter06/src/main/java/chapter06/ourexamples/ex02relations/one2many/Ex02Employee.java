package chapter06.ourexamples.ex02relations.one2many;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
//@Builder
public class Ex02Employee {

    public Ex02Employee() {
    }

    @Id
    @SequenceGenerator(name = "employee_generator", sequenceName = "seq_departments", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    private Long id;

    private String employeeName;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Ex02Department ex02Department;

    @Override
    public String toString() {
        return "Ex02Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}
