package kg.java.cafe.controllers.v1;

import kg.java.cafe.core.contracts.facades.CategoryFacade;
import kg.java.cafe.core.exceptions.EntityDuplicateException;
import kg.java.cafe.core.exceptions.EntityNotFoundException;
import kg.java.cafe.core.models.dtos.category.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryControllerV1 {
    private final CategoryFacade categoryFacade;

    public CategoryControllerV1(CategoryFacade categoryFacade) {
        this.categoryFacade = categoryFacade;
    }
    @PostMapping("/add")
    public ResponseEntity<CategoryDto> add(@RequestBody CreateCategoryDto model) {
        try {
            return ResponseEntity.ok(categoryFacade.add(model));
        }
        catch (EntityDuplicateException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<CategoryDto> update(@RequestBody UpdateCategoryDto model) {
        try {
            return ResponseEntity.ok(categoryFacade.update(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteCategoryDto model) {
        try {
            return ResponseEntity.ok(categoryFacade.delete(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<CategoryDto> findById(@RequestBody FindByIdCategoryDto model) {
        try {
            return ResponseEntity.ok(categoryFacade.findById(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
