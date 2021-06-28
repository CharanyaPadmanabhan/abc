package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data

public class Response {

    String productId;
    String productName;
    Double availQty;
}
