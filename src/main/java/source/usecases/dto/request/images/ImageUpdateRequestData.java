package source.usecases.dto.request.images;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import source.domain.entity.Images;

@Builder
@Getter
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class ImageUpdateRequestData {
    private Long id;

    private String name;

    private String path;

    public Images toEntity() {
        return Images.builder()
                .id(this.id)
                .name(this.name)
                .path(this.path)
                .build();
    }
}