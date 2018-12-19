package chapter06.ourexamples.ex01Basic;

import lombok.*;

import javax.persistence.*;

@Entity
@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Address {
    @Column(name = "street_name")
    private String street;
    @Column(name = "house_number")
    @Basic(optional = false)
    private String house;

    @Id
    private Long id;


}
