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
public class Ex11Employee {

    @Id
    @SequenceGenerator(name = "gen1", sequenceName = "seq1", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")
    private Long id;
    private String name;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Ex11EmployeeHistory history;

    public Ex11Employee() {
    }

    @Override
    public String toString() {
        return "Ex11Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", history=" + history.getRecord() +
                '}';
    }
}

