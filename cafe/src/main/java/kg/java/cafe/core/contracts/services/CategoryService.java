package kg.java.cafe.core.contracts.services;

import kg.java.cafe.core.exceptions.EntityDuplicateException;
import kg.java.cafe.core.exceptions.EntityNotFoundException;
import kg.java.cafe.core.models.dtos.category.*;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface CategoryService {
    CategoryDto add (CreateCategoryDto model) throws EntityDuplicateException;
    CategoryDto update (UpdateCategoryDto model) throws EntityNotFoundException;
    HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException;
    CategoryDto findById(FindByIdCategoryDto model) throws EntityNotFoundException;
    List<CategoryDto> findByCategoryName(FindByCategoryNameDto model);
}
