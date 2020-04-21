package guru.springframework.brewery.monolith.domain;

import guru.springframework.brewery.monolith.web.model.BeerStyleEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Beer extends BaseEntity {

    @Builder
    public Beer(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                String beerName, BeerStyleEnum beerStyle, String upc,
                Integer minOnHand, Integer quantityToBrew, BigDecimal price) {
        super(id, version, createdDate, lastModifiedDate);

        this.beerName = beerName;
        this.beerStyle = beerStyle;
        this.upc = upc;
        this.minOnHand = minOnHand;
        this.quantityToBrew = quantityToBrew;
        this.price = price;
    }

    private String beerName;
    private BeerStyleEnum beerStyle;

    @Column(unique = true)
    private String upc;

    // Used to trigger brew
    private Integer minOnHand;
    private Integer quantityToBrew;
    private BigDecimal price;

    // TODO - add inventory
}
