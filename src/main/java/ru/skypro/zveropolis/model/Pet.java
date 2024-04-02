package ru.skypro.zveropolis.model;

import lombok.Data;





@Data
public abstract class Pet {
     private  String name;
     private int age;

     private boolean limitedOpportunities;

}
