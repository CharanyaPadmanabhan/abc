package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Inventory {
    String productId;
    String prodName;
    String UOM;
    Double quantity;
    String availabledate;
}
