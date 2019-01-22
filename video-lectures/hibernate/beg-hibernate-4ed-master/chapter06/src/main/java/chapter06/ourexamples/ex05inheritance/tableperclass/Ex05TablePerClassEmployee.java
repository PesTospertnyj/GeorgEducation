package chapter06.ourexamples.ex05inheritance.tableperclass;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by gd on 1/21/2019.
 */
@Entity
@Data
public class Ex05TablePerClassEmployee extends Ex05TablePerClassPerson {

    private double salary;

}
