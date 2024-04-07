package ru.skypro.zveropolis.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sheltercat")
public class ShelterCat extends Shelter{
    @OneToMany(mappedBy = "shelterCat")
    Collection<Cat> cats;
}
