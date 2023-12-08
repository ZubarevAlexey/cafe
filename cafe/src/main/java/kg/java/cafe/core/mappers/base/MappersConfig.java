package kg.java.cafe.core.mappers.base;

import kg.java.cafe.core.mappers.CategoryMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {
    @Bean
    public CategoryMapper buildCategoryMapper() {
        return new CategoryMapper();
    }
}
