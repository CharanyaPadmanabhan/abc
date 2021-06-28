package com.example.demo.service;

import com.example.demo.model.Inventory;
import com.example.demo.model.Supply;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
@Service
public class Inventoryservice {

public List<Inventory> initialize(){
    List<Inventory> inventorylist=new ArrayList<Inventory>();
    Inventory i1=new  Inventory("Prod1","Shirt","EACH", 10.0, "2021-19-06");
    Inventory i2=new Inventory ("Prod1","Trousers","EACH", 20.0,"2021-21-06");
           Inventory i3=new Inventory ("Prod1","Trousers","EACH", 20.0,"2021-29-06");
Collections.addAll(inventorylist,i1,i2,i3);
return inventorylist;
}
public List<Supply> initializesupply()
{
    ArrayList<Supply> def=new ArrayList<Supply>();
    Supply s1=new Supply("Product1",new Date(2021-03-16),10.0,"");
    Supply s2 = new Supply ("Product2",new Date(2021-03-16),5.0,"");
        Supply s3 =  new Supply ("Product3",new Date(2021-03-16),30.0,"");
    Supply s4=  new  Supply ("Product4",new Date(2021-03-16),20.0,"");

    Collections.addAll(def,s1,s2,s3,s4);
    return def;

}
    }






