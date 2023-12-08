package kg.java.cafe.core.mappers;

import kg.java.cafe.core.models.dtos.category.CategoryDto;
import kg.java.cafe.core.models.dtos.category.CreateCategoryDto;
import kg.java.cafe.core.models.dtos.category.UpdateCategoryDto;
import kg.java.cafe.core.models.entities.CategoryEntity;

public class CategoryMapper {
    public CategoryDto toDomain(CategoryEntity model){
        return CategoryDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
    public CategoryEntity fromDomain(CreateCategoryDto model) {
        return CategoryEntity.builder()
                .name(model.getName())
                .build();
    }
    public CategoryEntity fromDomain(UpdateCategoryDto model) {
        return CategoryEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
