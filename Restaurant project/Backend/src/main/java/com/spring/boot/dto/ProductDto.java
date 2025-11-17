package com.spring.boot.dto;

import com.spring.boot.model.Category;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long productId;

    @NotBlank(message = "product.name.Required")
    private String productName;

    private String productDescription;

    @NotBlank(message = "product.price.required")
    private Double productPrice;

    private String productImagePath;

    private Long categoryId;
}
