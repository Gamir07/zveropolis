package ru.skypro.zveropolis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "petReport")
public class PetReport {
    @Id
    @GeneratedValue
    private long id;
    private byte[] dailyPhotoReport;
    private String filepath;
    private String mediaType;
    private long fileSize;
    private String generalCondition;
    private String behaviorChanges;
    private Date dateOfReport;
    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
