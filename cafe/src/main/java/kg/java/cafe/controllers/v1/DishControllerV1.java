package kg.java.cafe.controllers.v1;

import kg.java.cafe.core.contracts.facades.DishFacade;
import kg.java.cafe.core.exceptions.EntityDuplicateException;
import kg.java.cafe.core.exceptions.EntityNotFoundException;
import kg.java.cafe.core.models.dtos.dish.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dish")
public class DishControllerV1 {
    private final DishFacade dishFacade;

    public DishControllerV1(DishFacade dishFacade) {
        this.dishFacade = dishFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<DishDto> add(@RequestBody CreateDishDto model) {
        try {
            return ResponseEntity.ok(dishFacade.add(model));
        }
        catch (EntityDuplicateException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<DishDto> update(@RequestBody UpdateDishDto model) {
        try {
            return ResponseEntity.ok(dishFacade.update(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteDishDto model) {
        try {
            return ResponseEntity.ok(dishFacade.delete(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<DishDto> findById(@RequestBody FindByIdDishDto model) {
        try {
            return ResponseEntity.ok(dishFacade.findById(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }


}
