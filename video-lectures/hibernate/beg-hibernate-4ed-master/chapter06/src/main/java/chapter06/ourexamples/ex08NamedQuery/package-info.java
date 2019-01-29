/**
 * Created by gd on 1/29/2019.
 */

@org.hibernate.annotations.NamedQuery(name = "FIND_EMPLOYEE_BY_NAME2", query = "select e from Ex08Employee e where e.name = :name_param")
package chapter06.ourexamples.ex08NamedQuery;

//import org.hibernate.annotations.NamedQuery;