package chapter06.ourexamples.ex10enumSet;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ggavrysh on 2019-01-31.
 */
@Entity
@Data
public class Ex10Cv {

    @Id
    @SequenceGenerator(name = "ex10_generator", sequenceName = "seq_ex10", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ex10_generator")
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Ex10WorkTypeEnum preferredType;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Ex10WorkTypeEnum> workTypes;
}
