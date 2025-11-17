package com.spring.boot.dto;

import com.spring.boot.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private Long id;

    private String categoryName;

    private String CategoryLogo;

    private String categoryFlag;

    private List<ProductDto> productDtos;
}
