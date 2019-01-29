package chapter06.ourexamples.ex08NamedQuery;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Created by gd on 1/29/2019.
 */
@Entity
@Data
@NamedQuery(name = "FIND_EMPLOYEE_BY_NAME", query = "select e from Ex08Employee e where e.name = :name_param")
//@org.hibernate.annotations.NamedQuery(name = "FIND_EMPLOYEE_BY_NAME2", query = "select e from Ex08Employee e where e.name = :name_param")
public class Ex08Employee {
    @Id
    private Long id;

    private String name;

}
