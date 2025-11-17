package com.spring.boot.controller;

import ch.qos.logback.core.model.Model;
import com.spring.boot.dto.ProductDto;
import com.spring.boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:5174","http://localhost:5173"})
public class ProductController {
    private ProductService productService;
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/getProducts/categoryId/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.getProductsByCategoryId(categoryId));
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<ProductDto>> searchProducts(@PathVariable String keyword) {
        List<ProductDto> result = productService.searchProduct(keyword);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/product/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.addProduct(productDto));
    }

    @PostMapping("/productList/add")
    public ResponseEntity<List<ProductDto>> addProductList(@RequestBody List<ProductDto> productDtos) {
        return ResponseEntity.ok(productService.addProducts(productDtos));
    }

    @PutMapping("/product/edit")
    public ResponseEntity<ProductDto> editProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(productDto));
    }

    @PutMapping("productList/edit")
    public ResponseEntity<List<ProductDto>> editProductList(@RequestBody List<ProductDto> productDtos) {
        return ResponseEntity.ok(productService.updateProducts(productDtos));
    }

    @DeleteMapping("product/delete")
    public ResponseEntity<Void> deleteProduct(@RequestParam Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/productList/delete")
    public ResponseEntity<Void> deleteProductList(@RequestParam List<Long> productIds) {
        productService.deleteProductList(productIds);
        return ResponseEntity.ok().build();
    }
}
