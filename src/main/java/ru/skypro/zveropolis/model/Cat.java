package ru.skypro.zveropolis.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cat")
@NoArgsConstructor
public class Cat extends Pet {
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private ShelterCat shelterCat;

    List<Cat> catList;
}
