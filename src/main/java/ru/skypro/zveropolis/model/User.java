package ru.skypro.zveropolis.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class User {

    @Id
    private long chatId;
    private String name;
    private String phoneNumber;
    private boolean isVolunteer;

//    @OneToOne
//    @JoinColumn(name = "pet_id")
//    private Pet pet;

}
