package ru.skypro.zveropolis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "dog")
@NoArgsConstructor
public class Dog extends Pet {
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    ShelterDog shelterDog;
}
