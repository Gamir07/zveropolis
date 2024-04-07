package ru.skypro.zveropolis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@Getter
@Setter
public abstract class Shelter {

    @Id
    @GeneratedValue
    private Long id;

    private String information;

    private String address;

    private byte[] roadmap;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shelter shelter = (Shelter) o;
        return Objects.equals(id, shelter.id) && Objects.equals(information, shelter.information) && Objects.equals(address, shelter.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
