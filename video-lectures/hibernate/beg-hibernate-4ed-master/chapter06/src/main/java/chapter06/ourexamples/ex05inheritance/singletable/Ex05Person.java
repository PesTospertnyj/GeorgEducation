package chapter06.ourexamples.ex05inheritance.singletable;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

/**
 * Created by gd on 1/21/2019.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="DISCRIMINATOR",
        discriminatorType= DiscriminatorType.INTEGER
)
@DiscriminatorValue("1")
@Data
public class Ex05Person {

    @Id
    @SequenceGenerator(name = "ex05_generator", sequenceName = "seq_ex05", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex05_generator")
    private Long id;

    private String name;

}
