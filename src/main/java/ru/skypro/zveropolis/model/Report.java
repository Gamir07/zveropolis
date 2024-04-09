package ru.skypro.zveropolis.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Report {
    @Id
    @GeneratedValue
    private Long id;
    private String diet;
    private String healthAndAddiction;
    private String behavior;
    @OneToMany
    @JoinColumn(name = "photo_id")
    private List<Photo> photo;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Users> users;
    @OneToMany
    @JoinColumn(name = "pet_id")
    private List<Pet> pet;
}
