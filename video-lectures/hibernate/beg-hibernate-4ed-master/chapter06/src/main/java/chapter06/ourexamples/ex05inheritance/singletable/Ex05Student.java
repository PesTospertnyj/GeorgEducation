package chapter06.ourexamples.ex05inheritance.singletable;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by gd on 1/21/2019.
 */
@Entity
//@DiscriminatorValue("2")
@Data
public class Ex05Student extends Ex05Person {

    @Column(name = "group_name")
    private String group;

}
