package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AsyncResponse {
  Availability availability;
  String status;
}
