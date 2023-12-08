package kg.java.cafe.core.models.dtos.dish;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CreateDishDto {
    private String name;
    private Double price;
    private Long categoryId;
}
