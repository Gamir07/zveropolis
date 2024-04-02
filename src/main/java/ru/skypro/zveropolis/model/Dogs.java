package ru.skypro.zveropolis.model;


import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data

public class Dogs extends Pet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

}
