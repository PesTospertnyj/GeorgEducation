/**
 * Created by gd on 1/29/2019.
 */

@org.hibernate.annotations.NamedQuery(name = "FIND_EMPLOYEE_BY_NAME_AT_PACKAGE", query = "select e from Emp08 e where e.name = :name_param")
package chapter06.ourexamples.ex08NamedQueryNativeQuery;

//import org.hibernate.annotations.NamedQuery;