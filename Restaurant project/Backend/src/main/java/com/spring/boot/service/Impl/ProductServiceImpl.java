package com.spring.boot.service.Impl;

import com.spring.boot.dto.CategoryDto;
import com.spring.boot.dto.ProductDto;
import com.spring.boot.mapper.ProductMapper;
import com.spring.boot.model.Category;
import com.spring.boot.model.Product;
import com.spring.boot.repo.CategoryRepo;
import com.spring.boot.repo.ProductRepo;
import com.spring.boot.service.CategoryService;
import com.spring.boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductMapper productMapper;
    private ProductRepo productRepo;
    private CategoryService categoryService;
    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, ProductRepo productRepo, CategoryService categoryService) {
        this.productMapper = productMapper;
        this.productRepo = productRepo;
        this.categoryService = categoryService;

    }

    @Override
    public List<ProductDto> getProducts() {
        List<Product> products=productRepo.findAll();
        return productMapper.toProductDtos(products);
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        // Check if category exists
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        if(Objects.isNull(categoryDto)){
            throw new RuntimeException("category.notFound");
        }

        // Fetch products for this category
        List<Product> products = productRepo.findByCategoryId(categoryId);

        // If no products found, optionally return empty list
        if (products==null) {
            throw new RuntimeException("product.notFound");
        }

        return productMapper.toProductDtos(products);

    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        if(Objects.nonNull(productDto.getProductId())){
            throw new RuntimeException("product.id.notRequired");
        }
        if (Objects.isNull(productDto.getProductName())){
            throw new RuntimeException("product.name.Required");
        }
        if (Objects.isNull(productDto.getProductPrice())){
            throw new RuntimeException("product.price.required");
        }
        Optional<Product> productOptional=productRepo.findByProductName(productDto.getProductName());
        if(productOptional.isPresent()){
            throw new RuntimeException("product.Exist");
        }
        Product product = productRepo.save(productMapper.toProductEntity(productDto));
        productDto.setProductId(product.getProductId());
        return productDto;
    }

    @Override
    public List<ProductDto> addProducts(List<ProductDto> productDtos) {
        productDtos.forEach(this::addProduct);
        return productDtos;
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        if(Objects.isNull(productDto.getProductId())){
            throw new RuntimeException("product.id.Required");
        }
        productRepo.save(productMapper.toProductEntity(productDto));
        return productDto;
    }

    @Override
    public List<ProductDto> updateProducts(List<ProductDto> productDtos) {
        productDtos.forEach(this::updateProduct);
        return productDtos;
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> productOptional=productRepo.findById(productId);
        if(productOptional.isEmpty()){
            throw new RuntimeException("product.notFound");
        }
        productRepo.deleteById(productId);
    }

    @Override
    public void deleteProductList(List<Long> productIds) {
        productIds.forEach(productId->{
            Optional<Product> productOptional=productRepo.findById(productId);
            if(productOptional.isEmpty()){
                throw new RuntimeException("product.notFound");
            }
            productRepo.deleteById(productId);
        });

    }

    @Override
    public List<ProductDto> searchProduct(String keyword) {
        String searchKeyword=keyword.trim();
        List<Product> products=productRepo.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(searchKeyword,searchKeyword);
        return products.stream().map(productMapper::toProductDto).collect(Collectors.toList());
    }
}
