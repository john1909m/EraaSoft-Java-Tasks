package com.spring.boot.controller;

import com.spring.boot.dto.ChefDto;
import com.spring.boot.service.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = {"http://localhost:5174","http://localhost:5173","http://localhost:5175"})
public class ChefController {

    private ChefService chefService;
    @Autowired
    public void setChefService(ChefService chefService) {
        this.chefService = chefService;
    }

    @GetMapping("/getChefs")
    public ResponseEntity<List<ChefDto>> getChefs(){
        return ResponseEntity.ok().body(chefService.getChefs());
    }

}
