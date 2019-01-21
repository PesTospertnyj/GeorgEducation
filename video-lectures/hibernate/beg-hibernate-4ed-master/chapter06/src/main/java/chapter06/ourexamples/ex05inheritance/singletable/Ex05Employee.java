package chapter06.ourexamples.ex05inheritance.singletable;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by gd on 1/21/2019.
 */
@Entity
@DiscriminatorValue("3")
@Data
public class Ex05Employee extends Ex05Person {

    private double salary;

}
