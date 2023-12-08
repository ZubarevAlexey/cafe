package kg.java.cafe.core.mappers.base;

import kg.java.cafe.core.mappers.CategoryMapper;
import kg.java.cafe.core.mappers.DishMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {
    @Bean
    public CategoryMapper buildCategoryMapper() {
        return new CategoryMapper();
    }
    @Bean
    public DishMapper buildDishMapper() {
        return new DishMapper();
    }
}
