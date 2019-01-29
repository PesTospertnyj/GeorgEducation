package chapter06.ourexamples.ex02relations.one2many;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
//@Builder
public class Ex02Department {

    public Ex02Department() {
    }

    @Id
    @SequenceGenerator(name = "departments_generator", sequenceName = "seq_departments", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departments_generator")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "ex02Department")
    @OrderColumn(name = "employee_order")
//    @OrderBy(value = "employeeName asc")
//    @org.hibernate.annotations.OrderBy(clause = "employeeName asc")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Ex02Employee> ex02Employees;

    @OneToMany
    @JoinTable(name = "dep2emp",
            joinColumns = {@JoinColumn(name = "dep_id")},
            inverseJoinColumns = {@JoinColumn(name = "epm_id")})
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Ex02Employee> globalEx02Employees;

    @Override
    public String toString() {
        return "Ex02Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
