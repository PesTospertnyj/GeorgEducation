package chapter06.ourexamples.embedableid;

import javax.persistence.*;

@Entity
public class Example {

    @Id
    @SequenceGenerator(name = "employee_generator", sequenceName = "seq_employee", allocationSize = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    private Long id;

    @OneToOne
    private GlobalStudentGroup globalStudentGroup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GlobalStudentGroup getGlobalStudentGroup() {
        return globalStudentGroup;
    }

    public void setGlobalStudentGroup(GlobalStudentGroup globalStudentGroup) {
        this.globalStudentGroup = globalStudentGroup;
    }
}
