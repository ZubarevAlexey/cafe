package kg.java.cafe.data;

import kg.java.cafe.core.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findCategoryEntityByName(String name);

    List<CategoryEntity> findCategoryEntitiesByNameContains(String name);
}