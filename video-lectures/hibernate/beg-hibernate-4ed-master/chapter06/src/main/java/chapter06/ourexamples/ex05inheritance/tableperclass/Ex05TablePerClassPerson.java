package chapter06.ourexamples.ex05inheritance.tableperclass;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by gd on 1/21/2019.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public class Ex05TablePerClassPerson {

    @Id
    @SequenceGenerator(name = "ex05_generator", sequenceName = "seq_ex05", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex05_generator")
    private Long id;

    private String name;

}
