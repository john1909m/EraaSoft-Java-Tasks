package com.spring.boot.service;

import com.spring.boot.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getCategories();
    CategoryDto getCategoryById(Long id);
    CategoryDto addCategory(CategoryDto categoryDto);
    List<CategoryDto> addCategories(List<CategoryDto> categoryDtos);
    CategoryDto updateCategory(CategoryDto categoryDto);
    List<CategoryDto> updateCategories(List<CategoryDto> categoryDtos);
    void deleteCategory(Long id);
    void deleteCategories(List<Long> ids);

}
