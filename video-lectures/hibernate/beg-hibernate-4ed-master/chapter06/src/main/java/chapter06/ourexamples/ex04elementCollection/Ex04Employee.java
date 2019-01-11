package chapter06.ourexamples.ex04elementCollection;

import chapter06.ourexamples.ex03many2many.Course;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
public class Ex04Employee {
    @Id
    @SequenceGenerator(name = "ex04_generator", sequenceName = "seq_ex04", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex04_generator")
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "employee_phones", joinColumns = {@JoinColumn(name = "emp_id")})
    @Column(name = "user_phone")
    private List<String> phones;
}
