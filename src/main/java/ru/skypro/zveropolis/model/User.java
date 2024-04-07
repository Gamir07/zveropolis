package ru.skypro.zveropolis.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name = "userTable")
public class User {

    @Id
    @GeneratedValue
    private long chatId;
    private String name;

    @Size(min = 10, max = 10)
    private String phoneNumber;
    private boolean isVolunteer;
    private Date dateOfAdoption;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
