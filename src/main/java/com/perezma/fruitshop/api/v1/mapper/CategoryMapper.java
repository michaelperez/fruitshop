package com.perezma.fruitshop.api.v1.mapper;

import com.perezma.fruitshop.api.v1.model.CategoryDTO;
import com.perezma.fruitshop.domain.Category;

public interface CategoryMapper {
    CategoryDTO categoryToCategoryDTO(Category category);
}
