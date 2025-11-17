package com.spring.boot.mapper;

import com.spring.boot.dto.CategoryDto;
import com.spring.boot.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toCategoryDto(Category category);
    Category toCategoryEntity(CategoryDto categoryDto);
    List<CategoryDto> toCategoryDtos(List<Category> categories);
    List<Category> toCategoryEntities(List<CategoryDto> categoryDtos);

}
