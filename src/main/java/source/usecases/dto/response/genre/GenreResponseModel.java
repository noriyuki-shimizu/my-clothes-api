package source.usecases.dto.response.genre;

import lombok.Data;
import lombok.Value;

@Value(staticConstructor = "of")
@Data
public class GenreResponseModel {
    private Long id;

    private String name;

    private String color;
}
