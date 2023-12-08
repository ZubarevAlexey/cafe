package kg.java.cafe.domain.services;

import kg.java.cafe.core.contracts.services.CategoryService;
import kg.java.cafe.core.exceptions.EntityDuplicateException;
import kg.java.cafe.core.exceptions.EntityNotFoundException;
import kg.java.cafe.core.mappers.CategoryMapper;
import kg.java.cafe.core.models.dtos.category.*;
import kg.java.cafe.data.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto add(CreateCategoryDto model) throws EntityDuplicateException {
        var category = categoryRepository.findCategoryEntityByName(model.getName());
        if (category.isPresent()) throw new EntityDuplicateException();
        var entity = categoryMapper.fromDomain(model);
        categoryRepository.save(entity);
        return categoryMapper.toDomain(entity);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = category.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .build();
        categoryRepository.save(entity);
        return categoryMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteCategoryDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        categoryRepository.delete(category);
        return HttpStatus.OK;
    }

    @Override
    public CategoryDto findById(FindByIdCategoryDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return categoryMapper.toDomain(category);
    }
}
