package com.example.demo.service;

import com.example.demo.model.Availability;
import com.example.demo.model.Capacity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
public class CapacityService {
    List<Capacity> capacityList=new ArrayList<Capacity>();
    public List<Capacity> initialize(){
      Capacity c1=new Capacity("Store001", "Prod1", new Date(2021 - 02 - 19), 0.0);
        Capacity c2=new Capacity ("Store002", "Prod1", new Date(2021 - 02 - 20), 2.0);
        Capacity c3=new Capacity  ("Store003", "Prod1", new Date(2021 - 02 - 21), 2.0);
        Capacity c4=new Capacity ("Store004", "Prod1", new Date(2021 - 02 - 22), 0.0);
Collections.addAll(capacityList,c1,c2,c3,c4);
return capacityList;
    }
    @Async
    public CompletableFuture<Capacity> getCapacity(String storeNo){
        initialize();
        Optional<Capacity> b=capacityList.stream().filter(x->x.getStoreNo().equals(storeNo)).findAny();
        return CompletableFuture.completedFuture(b.get());

    }
}
