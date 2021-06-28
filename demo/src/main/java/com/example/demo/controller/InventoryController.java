package com.example.demo.controller;

import com.example.demo.model.Inventory;
import com.example.demo.model.Response;
import com.example.demo.service.Inventoryservice;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.certpath.OCSPResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
@Slf4j
@RestController

/*public class InventoryController {
   /* @Autowired
    Inventoryservice service;
    @Autowired
    Response response;

    @PostMapping("/createRecords")
    public ResponseEntity<?> getinventory(@RequestBody Inventory inventory) throws ParseException {
        List<Inventory> inventorylist = service.initialize();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        Date date = new Date();
        Double quantity = 0.0;

        Date tenDays = DateUtils.addDays(date, 10);
        if ((sdf.parse(inventory.getAvailabledate())).after(tenDays) && (sdf.parse(inventory.getAvailabledate())).before(date)) {
            log.info("Bad Request");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            log.trace("The dates exists within the given range");

          Double quantity1= inventorylist.stream().filter(x-> {

                            sdf.parse(x.getAvailabledate()).equals(sdf.parse(inventory.getAvailabledate()));


          }).collect(Collectors.summingDouble(p->p.getQuantity()));

response.setAvailQty(quantity1);
              /* inventorylist.stream().filter(sdf.parse(inventory.getAvailabledate()).equals(sdf.parse(a.getAvailabledate())) || sdf.parse(inventory.getAvailabledate()).before(sdf.parse(a.getAvailabledate())).
                    quantity = quantity + inventorylist.*/




           // return new ResponseEntity<>(response, HttpStatus.OK);
     //   }



//}










//}