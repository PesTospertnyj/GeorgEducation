package chapter06.ourexamples.ex06superclass;

import lombok.Data;

import javax.persistence.*;
import java.util.stream.LongStream;

/**
 * Created by gd on 1/23/2019.
 */
@Data
@Entity
@AttributeOverride(name = "phone", column = @Column(name = "fax"))
public class Ex06Student extends Ex06Person {

   @Id
   @SequenceGenerator(name = "ex06_generator", sequenceName = "seq_ex06", allocationSize = 20)
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex06_generator")
   private Long id;

   private String groupCode;

}
