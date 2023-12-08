package kg.java.cafe.core.models.dtos.dish;

import kg.java.cafe.core.models.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class DishDto {
    private Long id;
    private String name;
    private Double price;
    private CategoryDto category;
}
