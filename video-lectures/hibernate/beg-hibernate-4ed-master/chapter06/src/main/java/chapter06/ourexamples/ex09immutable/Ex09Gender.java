package chapter06.ourexamples.ex09immutable;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by gd on 1/30/2019.
 */
@Entity
@Immutable
@Data
public class Ex09Gender {

    @Id
    private Long id;

    private String name;
}
