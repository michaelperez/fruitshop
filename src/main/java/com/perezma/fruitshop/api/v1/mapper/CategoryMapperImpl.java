package com.perezma.fruitshop.api.v1.mapper;

import com.perezma.fruitshop.api.v1.model.CategoryDTO;
import com.perezma.fruitshop.domain.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {

        if (category == null) {
            return null;
        }

        CategoryDTO dto = new CategoryDTO();

        dto.setId(category.getId());
        dto.setName(category.getName());

        return dto;
    }
}
