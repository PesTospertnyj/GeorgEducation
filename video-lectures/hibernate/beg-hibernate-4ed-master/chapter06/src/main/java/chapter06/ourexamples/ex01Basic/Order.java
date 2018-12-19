package chapter06.ourexamples.ex01Basic;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {

    @Id
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "house", column = @Column(name = "Haus")),
           @AttributeOverride(name = "street", column = @Column(name = "Strasse")),

    })
    private Address deliveryAddress;

    private String comment;

    public String getStreet() {
        return deliveryAddress.getStreet();
    }

}
