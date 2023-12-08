package kg.java.cafe.domain.facades;

import kg.java.cafe.core.contracts.facades.DishFacade;
import kg.java.cafe.core.contracts.services.DishService;
import kg.java.cafe.core.exceptions.EntityDuplicateException;
import kg.java.cafe.core.exceptions.EntityNotFoundException;
import kg.java.cafe.core.models.dtos.dish.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishFacadeImpl implements DishFacade {
    private final DishService dishService;

    public DishFacadeImpl(DishService dishService) {
        this.dishService = dishService;
    }

    @Override
    public DishDto add(CreateDishDto model) throws EntityNotFoundException, EntityDuplicateException {
        return dishService.add(model);
    }

    @Override
    public DishDto update(UpdateDishDto model) throws EntityNotFoundException {
        return dishService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteDishDto model) throws EntityNotFoundException {
        return dishService.delete(model);
    }

    @Override
    public DishDto findById(FindByIdDishDto model) throws EntityNotFoundException {
        return dishService.findById(model);
    }

    @Override
    public List<DishDto> findByCategoryName(FindDishesByCategoryNameDto model) {
        return dishService.findByCategoryName(model);
    }

    @Override
    public List<DishDto> findByPrice(FindDishesByPrice model) {
        return dishService.findByPrice(model);
    }
}
