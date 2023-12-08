package kg.java.cafe.core.models.dtos.dish;

import kg.java.cafe.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateDishDto extends BaseDto {
    private String name;
    private Double price;
    private Long categoryId;
}
