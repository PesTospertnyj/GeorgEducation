package chapter06.ourexamples.ex05inheritance.joinedtable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by gd on 1/21/2019.
 */
@Entity
@DiscriminatorValue("2")
@Data
public class Ex05JoinedStudent extends Ex05JoinedPerson {

    @Column(name = "group_name")
    private String group;

}
