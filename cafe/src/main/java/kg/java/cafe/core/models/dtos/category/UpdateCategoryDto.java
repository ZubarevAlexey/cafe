package kg.java.cafe.core.models.dtos.category;

import kg.java.cafe.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateCategoryDto extends BaseDto {
    private String name;
}
