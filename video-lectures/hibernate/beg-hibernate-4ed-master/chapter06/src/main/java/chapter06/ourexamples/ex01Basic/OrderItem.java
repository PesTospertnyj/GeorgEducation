package chapter06.ourexamples.ex01Basic;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//@Data
@SecondaryTables({
        @SecondaryTable(name = "comments")
})
public class OrderItem {

    @Id
    private Long id;

    @Basic(optional = false, fetch = FetchType.LAZY)
    @Column(length = 25, unique = true)
    private String name;

    @Transient
    private String upperCaseName;

    @Column(name = "items_number", columnDefinition = "NUMERIC (10, 2) NOT NULL DEFAULT 3",
            insertable = false, updatable = false
    )
    private Integer quantity;

    @Column(scale = 3, precision = 6)
    private BigDecimal price;

    @Column(nullable = false, table = "comments"
    )
    private String comment;



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
