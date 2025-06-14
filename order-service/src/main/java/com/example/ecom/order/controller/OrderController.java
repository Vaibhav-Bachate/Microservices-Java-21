package com.example.ecom.order.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public List<String> getOrders() {
        return List.of("Order#1001", "Order#1002", "Order#1003");
    }
}
