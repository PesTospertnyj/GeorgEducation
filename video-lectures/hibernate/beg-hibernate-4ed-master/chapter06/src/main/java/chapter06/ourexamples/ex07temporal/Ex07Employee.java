package chapter06.ourexamples.ex07temporal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by gd on 1/29/2019.
 */
@Entity
@Data
public class Ex07Employee {

    @Id
    private Long id;

    private Date date1;

    private Time time1;

    private Timestamp timestamp1;

//    @Temporal(TemporalType.)
    private java.util.Date utilDate;
}
