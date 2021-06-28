package com.example.demo.controller;

import com.example.demo.model.Supply;
import com.example.demo.service.Inventoryservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
@RestController
public class SupplyController {
    @Autowired
    Inventoryservice service;

    @PostMapping("/supply")
    public Supply getupdated(@RequestBody Supply supply) {
        List<Supply> def = service.initializesupply();
        if (def.stream().anyMatch(x -> x.getProductId().equals(supply.getProductId()) && x.getDate().before(supply.getDate()))) {

 supply.setQuantity(Double.sum(supply.getQuantity(),def.stream().filter(x -> x.getProductId().equals(supply.getProductId()) && x.getDate().before(supply.getDate())).findAny().get().getQuantity()));
                supply.setStatus("updated");
            } else {
                supply.setStatus("exists");


            }



        return supply;
    }
}