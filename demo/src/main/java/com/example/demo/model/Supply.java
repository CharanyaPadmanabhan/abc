package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinitions;
import java.util.Date;

@Data
@AllArgsConstructor
public class Supply {
    String productId;
    Date date;
    Double quantity;
    String status;
}
