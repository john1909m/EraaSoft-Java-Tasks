package com.spring.boot.mapper;

import com.spring.boot.dto.CategoryDto;
import com.spring.boot.dto.ChefDto;
import com.spring.boot.model.Category;
import com.spring.boot.model.Chef;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChefMapper {
    ChefDto toChefDto(Chef chef);
    Chef toChefEntity(ChefDto chefDto);
}
