package ru.skypro.zveropolis.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(schema = "user")
public class User {

    @Id
    private long chatId;
    private String name;
    private String phoneNumber;
    private boolean isVolunteer;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
