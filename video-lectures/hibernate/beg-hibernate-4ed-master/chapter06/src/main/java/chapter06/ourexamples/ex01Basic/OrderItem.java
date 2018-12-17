package chapter06.ourexamples.ex01Basic;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@Builder
@NoArgsConstructor
@EqualsAndHashCode
//@Data
public class OrderItem {

    @Id
    private Long id;

    @Basic(optional = false, fetch = FetchType.LAZY)
    private String name;

    @Transient
    private String upperCaseName;

    @Column(name = "items_number", columnDefinition = "NUMERIC (10, 2) NOT NULL DEFAULT 3",
            insertable = false, updatable = false
    )
    private Integer quantity;

    public OrderItem(Long id, String name) {
        this.id = id;
        this.name = name;
        this.upperCaseName = name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name;
        this.upperCaseName = name.toUpperCase();
    }
}
