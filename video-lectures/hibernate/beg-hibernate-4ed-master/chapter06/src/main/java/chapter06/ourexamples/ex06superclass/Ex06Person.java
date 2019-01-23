package chapter06.ourexamples.ex06superclass;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by gd on 1/23/2019.
 */
@Data
@MappedSuperclass
public class Ex06Person {
   private String name;

   @Column(name = "phone_number")
   private String phone;
}
