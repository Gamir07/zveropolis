package ru.skypro.zveropolis.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Shelter {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private String datingRules;
    private String adoptionDocuments;
    private String transportationRecommendations;
    private String recommendationsArrangingBaby;
    private String recommendationsArrangingAdult;
    private String recommendationsArrangingWithFeatures;
    @Enumerated(EnumType.STRING)
    private TypeOfAnimal typeOfAnimal;
}
