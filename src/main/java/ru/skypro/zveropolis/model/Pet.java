package ru.skypro.zveropolis.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
public abstract class Pet {
    private String name;
    private int age;
    private boolean isHandicapped;

}
