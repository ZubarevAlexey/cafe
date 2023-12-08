package kg.java.cafe.data;

import kg.java.cafe.core.models.dtos.dish.DishDto;
import kg.java.cafe.core.models.entities.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DishRepository extends JpaRepository<DishEntity,Long> {
    Optional<DishEntity> findDishEntityByName(String name);
    @Query("select d from DishEntity d " +
            "where d.category.name=:categoryName" +
            " order by d.id")
    List<DishEntity> findByCategoryName(@Param("categoryName")String categoryName);

    @Query("select d from DishEntity d " +
            "where d.price>=:priceFrom and d.price<=:priceTo" +
            " order by d.price desc ")
    List<DishEntity> findByPrice(@Param("priceFrom") Double priceFrom,
                                 @Param("priceTo") Double priceTo);
}
