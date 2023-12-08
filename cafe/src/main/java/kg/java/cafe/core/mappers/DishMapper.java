package kg.java.cafe.core.mappers;

import kg.java.cafe.core.models.dtos.category.CategoryDto;
import kg.java.cafe.core.models.dtos.dish.CreateDishDto;
import kg.java.cafe.core.models.dtos.dish.DishDto;
import kg.java.cafe.core.models.dtos.dish.UpdateDishDto;
import kg.java.cafe.core.models.entities.DishEntity;

public class DishMapper {
    public DishDto toDomain(DishEntity model){
        var category = model.getCategory();
        return DishDto.builder()
                .id(model.getId())
                .name(model.getName())
                .price(model.getPrice())
                .category(CategoryDto.builder()
                        .name(category.getName())
                        .build())
                .build();
    }
    public DishEntity fromDomain(CreateDishDto model) {
        return DishEntity.builder()
                .name(model.getName())
                .price(model.getPrice())
                .build();
    }
    public DishEntity fromDomain(UpdateDishDto model) {
        return DishEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .price(model.getPrice())
                .build();
    }

}
