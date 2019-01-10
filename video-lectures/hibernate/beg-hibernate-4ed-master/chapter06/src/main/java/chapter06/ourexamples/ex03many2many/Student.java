package chapter06.ourexamples.ex03many2many;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
public class Student {

    @Id
    @SequenceGenerator(name = "st_generator", sequenceName = "seq_student", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "st_generator")
    private Long id;

    private String name;

    @ManyToMany
//    @JoinTable(name = "stud2course",
//            joinColumns = {@JoinColumn(name = "stud_id")},
//            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Collection<Course> courses;
}
