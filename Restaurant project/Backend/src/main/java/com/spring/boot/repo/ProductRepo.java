package com.spring.boot.repo;

import com.spring.boot.dto.ProductDto;
import com.spring.boot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByProductName(String productName);
    List<Product> findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
            String nameKeyword,
            String descriptionKeyword
    );
    List<Product> findByCategoryId(Long categoryId);
}
