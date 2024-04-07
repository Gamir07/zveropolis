package ru.skypro.zveropolis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Data
@Table(name = "pet")
public abstract class Pet {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;
    private boolean isHandicapped;
    private byte[] petPhoto;
}
