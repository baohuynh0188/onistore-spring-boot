package com.spring.onistore.controller;

import com.spring.onistore.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order-product")
public class OrderProductController {

    @Autowired
    private OrderProductRepository orderProductRepository;



}
