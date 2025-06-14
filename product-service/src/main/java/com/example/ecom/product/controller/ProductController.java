package com.example.ecom.product.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping
    public List<String> getAll() {
        return List.of("iPhone 15", "Samsung S24", "OnePlus 12");
    }
}
