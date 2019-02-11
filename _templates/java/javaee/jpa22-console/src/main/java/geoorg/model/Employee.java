package geoorg.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ggavrysh on 2019-02-11.
 */
@Entity
@Data
public class Employee {
    @Id
    @SequenceGenerator(name = "gen1", sequenceName = "seq1", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")
    private Long id;
    private String name;
}
