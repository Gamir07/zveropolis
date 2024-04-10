package ru.skypro.zveropolis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
public class PetReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Lob
//    private byte[] animalPhoto;

    private String ration;
    private String generalCondition;
    private String behaviorChanges;
}
