package source.domain.entity;

import lombok.Data;
import source.domain.entity.common.TimestampEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "clothes")
@Data
public class Clothes extends TimestampEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "image_id")
    private Images image;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "genre_id")
    @NotNull
    private Genres genre;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "brand_id")
    @NotNull
    private Brands brand;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "shop_id")
    @NotNull
    private Shops shop;

    @Column(name = "price")
    @NotNull
    private Integer price;

    @Temporal(TemporalType.DATE)
    @Column(name = "buy_date")
    @NotNull
    private Date buyDate;

}