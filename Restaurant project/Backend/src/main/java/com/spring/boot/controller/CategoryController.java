package com.spring.boot.controller;

import com.spring.boot.dto.CategoryDto;
import com.spring.boot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:5174","http://localhost:5173"})
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getCategories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PostMapping("/category/add")
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.addCategory(categoryDto));
    }

    @PostMapping("/categoryList/add")
    public ResponseEntity<List<CategoryDto>> addCategoryList(@RequestBody List<CategoryDto> categoryDtos) {
        return ResponseEntity.ok(categoryService.addCategories(categoryDtos));
    }

    @PutMapping("/category/edit")
    public ResponseEntity<CategoryDto> editCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto));
    }

    @PutMapping("/categoryList/edit")
    public ResponseEntity<List<CategoryDto>> editCategoryList(@RequestBody List<CategoryDto> categoryDtos) {
        return ResponseEntity.ok(categoryService.updateCategories(categoryDtos));
    }

    @DeleteMapping("category/delete/")
    public ResponseEntity<Void> deleteCategory(@RequestParam Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("categoryList/delete/")
    public ResponseEntity<List<CategoryDto>> deleteCategoryList(@RequestParam List<Long> ids) {
        categoryService.deleteCategories(ids);
        return ResponseEntity.ok().build();
    }






}
