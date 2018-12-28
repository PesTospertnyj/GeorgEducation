package chapter06.ourexamples.ex02relations.one2many;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//@Builder
public class Department {

    public Department() {
    }

    @Id
    @SequenceGenerator(name = "departments_generator", sequenceName = "seq_departments", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departments_generator")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
//    @OrderColumn
//    @OrderBy(value = "employeeName asc")
    @org.hibernate.annotations.OrderBy(clause = "employeeName asc")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany
    @JoinTable(name = "dep2emp",
            joinColumns = {@JoinColumn(name = "dep_id")},
            inverseJoinColumns = {@JoinColumn(name = "epm_id")})
    private List<Employee> globalEmployees;


}
