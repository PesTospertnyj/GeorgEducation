package chapter06.ourexamples.ex08NamedQueryNativeQuery;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by gd on 1/29/2019.
 */
@Entity(name = "Emp08")
@Table(name = "emps")
@Data
//@NamedQueries({
//        @NamedQuery(name = "FIND_EMPLOYEE_BY_NAME", query = "select e from Emp08 e where e.name = :name_param"),
//        @NamedQuery(name = "FIND_EMPLOYEE_BY_NAME2", query = "select e from Emp08 e where e.name = :name_param")
//})
@NamedQuery(name = "FIND_EMPLOYEE_BY_NAME", query = "select e from Emp08 e where e.name = :name_param")
@NamedQuery(name = "FIND_EMPLOYEE_BY_SALARY_RANGE", query = "select e from Emp08 e")
//
//@org.hibernate.annotations.NamedQuery(name = "FIND_EMPLOYEE_BY_NAME2", query = "select e from Ex08Employee e where e.name = :name_param")
@NamedNativeQuery(name = "NATIVE_EMP_BY_SALARY_RANGE",
        query = "select emp_name from emps " +
        " WHERE emp_salary BETWEEN :lower_bound and :higher_bound")
public class Ex08Employee {
    @Id
    private Long id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_salary")
    private double salary;

}
