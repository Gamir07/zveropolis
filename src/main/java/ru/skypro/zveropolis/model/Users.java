package ru.skypro.zveropolis.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
//@Table(schema = "users")
public class Users {
    @Id
    private long chatId;
    private String firstName;
    private String username;
    private String phoneNumber;
    private boolean isVolunteer;
    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
