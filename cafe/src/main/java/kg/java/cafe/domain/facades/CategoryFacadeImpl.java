package kg.java.cafe.domain.facades;

import kg.java.cafe.core.contracts.facades.CategoryFacade;
import kg.java.cafe.core.contracts.services.CategoryService;
import kg.java.cafe.core.exceptions.EntityDuplicateException;
import kg.java.cafe.core.exceptions.EntityNotFoundException;
import kg.java.cafe.core.models.dtos.category.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryFacadeImpl implements CategoryFacade {
    private final CategoryService categoryService;

    public CategoryFacadeImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto add(CreateCategoryDto model) throws EntityDuplicateException {
        return categoryService.add(model);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException {
        return categoryService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException {
        return categoryService.delete(model);
    }

    @Override
    public CategoryDto findById(FindByIdCategoryDto model) throws EntityNotFoundException {
        return categoryService.findById(model);
    }

    @Override
    public List<CategoryDto> findByCategoryName(FindByCategoryNameDto model) {
        return categoryService.findByCategoryName(model);
    }
}
