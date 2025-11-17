package com.spring.boot.service.Impl;

import com.spring.boot.dto.CategoryDto;
import com.spring.boot.mapper.CategoryMapper;
import com.spring.boot.model.Category;
import com.spring.boot.repo.CategoryRepo;
import com.spring.boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepo categoryRepo;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo, CategoryMapper categoryMapper) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream().map(category ->
                categoryMapper.toCategoryDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()) {
            return categoryMapper.toCategoryDto(categoryOptional.get());
        }
        else  {
            throw new RuntimeException("category.notFound");
        }

    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        if (Objects.nonNull(categoryDto.getId())) {
            throw new RuntimeException("category.id.notRequired");
        }
        if(Objects.isNull(categoryDto.getCategoryName())) {
            throw new RuntimeException("category.name.Required");
        }
        if(Objects.isNull(categoryDto.getCategoryLogo())) {
            throw new RuntimeException("category.logo.Required");
        }
        if(Objects.isNull(categoryDto.getCategoryFlag())) {
            throw new RuntimeException("category.flag.Required");
        }
        Optional<Category> categoryOptional = categoryRepo.findByCategoryName(categoryDto.getCategoryName());
        if(categoryOptional.isPresent()){
            throw new RuntimeException("category.exist");
        }
        Category category = categoryRepo.save(categoryMapper.toCategoryEntity(categoryDto));
        categoryDto.setId(category.getId());
        return categoryDto;
    }

    @Override
    public List<CategoryDto> addCategories(List<CategoryDto> categoryDtos) {
        categoryDtos.forEach(this::addCategory);
        return categoryDtos;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        if (Objects.isNull(categoryDto.getId())) {
            throw new RuntimeException("category.id.Required");
        }
        categoryRepo.save(categoryMapper.toCategoryEntity(categoryDto));
        return categoryDto;
    }

    @Override
    public List<CategoryDto> updateCategories(List<CategoryDto> categoryDtos) {
        categoryDtos.forEach(this::updateCategory);
        return categoryDtos;
    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if(categoryOptional.isEmpty()){
            throw new RuntimeException("category.notFound");
        }
        categoryRepo.deleteById(id);
    }

    @Override
    public void deleteCategories(List<Long> ids) {
        ids.forEach(categoryId -> {
            Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
            if(categoryOptional.isEmpty()){
                throw new RuntimeException("category.notFound");
            }
            categoryRepo.deleteById(categoryId);
        });
    }
}
