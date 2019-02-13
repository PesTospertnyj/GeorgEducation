package chapter06.ourexamples.ex11relation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by ggavrysh on 2019-02-11.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
public class Ex11EmployeeHistory {

    @Id
    @SequenceGenerator(name = "gen2", sequenceName = "seq1", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen2")
    private Long id;

    @OneToOne
    @JoinColumn(name = "emp_id")
    private Ex11Employee employee;

    private String record;

    public Ex11EmployeeHistory() {
    }
}
