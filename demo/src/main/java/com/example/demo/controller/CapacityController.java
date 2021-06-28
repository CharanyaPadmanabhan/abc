package com.example.demo.controller;

import com.example.demo.model.AsyncResponse;
import com.example.demo.model.Availability;
import com.example.demo.model.Capacity;
import com.example.demo.service.AvailabilityService;
import com.example.demo.service.CapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class CapacityController {
    @Autowired
    AvailabilityService availabilityService;
    @Autowired
    CapacityService capacityService;
@PostMapping("/getProdAvailability")
    public ResponseEntity<?> getProdAvailability(@RequestBody Availability availability) throws ExecutionException, InterruptedException {
        availabilityService.initialize();
        capacityService.initialize();
        CompletableFuture<Availability> availabilityOrders= availabilityService.getOrders(availability.getStoreNo());
        CompletableFuture<Capacity> capacityOrders= capacityService.getCapacity(availability.getStoreNo());
        CompletableFuture.allOf(availabilityOrders,capacityOrders).join();
        if((availabilityOrders.get().getQuantity() > 0.0) && (capacityOrders.get().getCapcity() > 0.0)){
            AsyncResponse a=new AsyncResponse(availabilityOrders.get(),"Available");
            return new ResponseEntity(a,HttpStatus.OK);
        }
        else
        {
            AsyncResponse a=new AsyncResponse(availabilityOrders.get(),"No capacity");
            return new ResponseEntity(a,HttpStatus.OK);
        }

    }
}
