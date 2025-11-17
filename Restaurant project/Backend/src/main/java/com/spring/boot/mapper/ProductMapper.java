package com.spring.boot.mapper;

import com.spring.boot.dto.CategoryDto;
import com.spring.boot.dto.ProductDto;
import com.spring.boot.model.Category;
import com.spring.boot.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toProductDto(Product product);

    @Mapping(target = "category", ignore = true)
    Product toProductEntity(ProductDto productDto);

    List<ProductDto> toProductDtos(List<Product> products);

    List<Product> toProductEntities(List<ProductDto> productDtos);

}
