package source.controller.shops.crud.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Value;

@Value(staticConstructor = "of")
@Data
public class ShopResponseModel {
    private Long id;

    private String name;

    private String link;

    private String stationName;

    private Long imageId;

    private String imageLink;

    private String address;

    private String businessHours;

    private String tel;

    @JsonProperty("isDeleted")
    private Boolean isDeleted;
}
