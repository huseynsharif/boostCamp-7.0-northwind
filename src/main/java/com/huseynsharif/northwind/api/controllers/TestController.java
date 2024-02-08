package com.huseynsharif.northwind.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")

public class TestController {

    @GetMapping("/salam")
    public String salamla(){
        return "<h1>Salam, BoostCamp 7.0!</h1>";
    }

}
