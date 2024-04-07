package ru.skypro.zveropolis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "ShelterDog")
@Data
@NoArgsConstructor
public class ShelterDog {
    @Column(name = "information")
    private String information;

    @Column(name = "address")
    private String address;

    @Column(name = "roadmap")
    private String roadmap;
    @Id
    @GeneratedValue
    private Long id;


}
