package ru.skypro.zveropolis.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Data
public class PetReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] petPhoto;

    private String ration;
    private String generalCondition;
    private String behaviorChanges;

    @Override
    public String toString() {
        return "PetReport{" +
                "id=" + id +
                ", petPhoto=" + Arrays.toString(petPhoto) +
                ", ration='" + ration + '\'' +
                ", generalCondition='" + generalCondition + '\'' +
                ", behaviorChanges='" + behaviorChanges + '\'' +
                '}';
    }
}
