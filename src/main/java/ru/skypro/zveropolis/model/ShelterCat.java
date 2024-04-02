package ru.skypro.zveropolis.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity(name = "ShelterDog")
public class ShelterCat{
    @Column(name = "information")
    private String information;

    @Column(name = "address")
    private String address;

    @Column(name = "roadmap")
    private String roadmap;
    @Id
    private Long id;

    public ShelterCat() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ShelterCat(String information, String address, String roadmap, Long id) {
        this.information = information;
        this.address = address;
        this.roadmap = roadmap;
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(String roadmap) {
        this.roadmap = roadmap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShelterCat that = (ShelterCat) o;
        return Objects.equals(information, that.information) && Objects.equals(address, that.address) && Objects.equals(roadmap, that.roadmap) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(information, address, roadmap, id);
    }

    @Override
    public String toString() {
        return "ShelterCat{" +
                "information='" + information + '\'' +
                ", address='" + address + '\'' +
                ", roadmap='" + roadmap + '\'' +
                ", id=" + id +
                '}';
    }
}
