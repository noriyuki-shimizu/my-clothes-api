package source.usecases.dto.request.clothes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import source.domain.entity.*;

import java.util.Date;

@Builder
@Getter
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class ClothesUpdateRequestData {

    private Long id;

    private Long imageId;

    private String imageName;

    private String imagePath;

    private Long genreId;

    private Long brandId;

    private Long shopId;

    private Integer price;

    private Date buyDate;

    public Clothes toEntity(Long userId) {
        Images image = Images.builder()
                .id(this.imageId)
                .path(this.imagePath)
                .build();

        return Clothes.builder()
                .id(this.id)
                .userId(userId)
                .genre(Genres.builder().id(this.genreId).build())
                .brand(Brands.builder().id(this.brandId).build())
                .shop(Shops.builder().id(this.shopId).build())
                .price(this.price)
                .buyDate(this.buyDate)
                .build();
    }

}
