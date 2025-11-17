package com.spring.boot.service;


import com.spring.boot.dto.ProductDto;
import com.spring.boot.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();
    List<ProductDto> getProductsByCategoryId(Long categoryId);
    ProductDto addProduct(ProductDto productDto);
    List<ProductDto> addProducts(List<ProductDto> productDtos);
    ProductDto updateProduct(ProductDto productDto);
    List<ProductDto> updateProducts(List<ProductDto> productDtos);
    void deleteProduct(Long productId);
    void deleteProductList(List<Long> productIds);
    List<ProductDto> searchProduct(String keyword);

}
