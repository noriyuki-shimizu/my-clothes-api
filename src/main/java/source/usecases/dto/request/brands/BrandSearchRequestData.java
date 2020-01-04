package source.usecases.dto.request.brands;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * ブランドの検索フォームのデータ.
 */
@Builder
@Getter
@AllArgsConstructor(onConstructor = @__(@JsonIgnore))
@NoArgsConstructor
public class BrandSearchRequestData {
    /** 名称 */
    private String name;

    /** 発祥国 */
    private String country;

    /** 削除フラグ */
    private Boolean isDeleted;
}