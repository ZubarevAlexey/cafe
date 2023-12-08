package kg.java.cafe.core.contracts.services;

import kg.java.cafe.core.exceptions.EntityDuplicateException;
import kg.java.cafe.core.exceptions.EntityNotFoundException;
import kg.java.cafe.core.models.dtos.dish.*;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface DishService {
    DishDto add(CreateDishDto model) throws EntityNotFoundException, EntityDuplicateException;

    DishDto update(UpdateDishDto model) throws EntityNotFoundException;

    HttpStatus delete(DeleteDishDto model) throws EntityNotFoundException;

    DishDto findById(FindByIdDishDto model) throws EntityNotFoundException;

    List<DishDto> findByCategoryName(FindDishesByCategoryNameDto model);
}
