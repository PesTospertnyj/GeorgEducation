package chapter06.ourexamples.ex03many2many;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "st_generator")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Student> students;
}
