package kg.java.cafe.domain.services;

import jakarta.transaction.Transactional;
import kg.java.cafe.core.contracts.services.DishService;
import kg.java.cafe.core.exceptions.EntityDuplicateException;
import kg.java.cafe.core.exceptions.EntityNotFoundException;
import kg.java.cafe.core.mappers.DishMapper;
import kg.java.cafe.core.models.dtos.dish.*;
import kg.java.cafe.data.CategoryRepository;
import kg.java.cafe.data.DishRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;
    private final CategoryRepository categoryRepository;

    public DishServiceImpl(DishRepository dishRepository, DishMapper dishMapper, CategoryRepository categoryRepository) {
        this.dishRepository = dishRepository;
        this.dishMapper = dishMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public DishDto add(CreateDishDto model) throws EntityNotFoundException, EntityDuplicateException {
        var category = categoryRepository.findById(model.getCategoryId()).orElseThrow(EntityNotFoundException::new);
        var dish = dishRepository.findDishEntityByName(model.getName());
        if (dish.isPresent()) throw new EntityDuplicateException();
        var entity = dishMapper.fromDomain(model);
        entity.setCategory(category);
        dishRepository.save(entity);
        return dishMapper.toDomain(entity);
    }

    @Override
    public DishDto update(UpdateDishDto model) throws EntityNotFoundException {
        var category = categoryRepository.findById(model.getCategoryId()).orElseThrow(EntityNotFoundException::new);
        var dish = dishRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = dish.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .price(model.getPrice())
                .category(category)
                .build();
        dishRepository.save(entity);
        return dishMapper.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteDishDto model) throws EntityNotFoundException {
        var dish = dishRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        dishRepository.delete(dish);
        return HttpStatus.OK;
    }

    @Override
    public DishDto findById(FindByIdDishDto model) throws EntityNotFoundException {
        var dish = dishRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return dishMapper.toDomain(dish);
    }

    @Override
    public List<DishDto> findByCategoryName(FindDishesByCategoryNameDto model) {
        var dishes = dishRepository.findByCategoryName(model.getCategoryName());
        return dishes.stream().map(dishMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<DishDto> findByPrice(FindDishesByPrice model) {
        var dishes = dishRepository.findByPrice(model.getPriceFrom(), model.getPriceTo());
        return dishes.stream().map(dishMapper::toDomain).collect(Collectors.toList());
    }


}
