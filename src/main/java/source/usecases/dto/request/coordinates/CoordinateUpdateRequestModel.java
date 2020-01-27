package source.usecases.dto.request.coordinates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class CoordinateUpdateRequestModel {
    private String season;

    private Long imageId;

    private String imageLink;

    private Set<Long> clothingIds;
}