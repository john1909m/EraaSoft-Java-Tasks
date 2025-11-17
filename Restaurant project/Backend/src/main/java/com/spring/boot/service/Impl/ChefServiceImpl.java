package com.spring.boot.service.Impl;

import com.spring.boot.dto.ChefDto;
import com.spring.boot.mapper.ChefMapper;
import com.spring.boot.model.Chef;
import com.spring.boot.repo.ChefRepo;
import com.spring.boot.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChefServiceImpl implements ChefService {

    private ChefMapper chefMapper;
    private ChefRepo chefRepo;

    @Autowired
    public ChefServiceImpl(ChefMapper chefMapper, ChefRepo chefRepo) {
        this.chefMapper = chefMapper;
        this.chefRepo = chefRepo;
    }

    @Override
    public List<ChefDto> getChefs() {
        List<Chef> chefs=chefRepo.findAll();
        return chefs.stream().map(chefMapper::toChefDto).collect(Collectors.toList());
    }
}
