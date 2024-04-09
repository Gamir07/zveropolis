package ru.skypro.zveropolis.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Photo {
    @Id
    @GeneratedValue
    private Long id;
    private Long fileSize;
    private String mediaType;
    private byte[] data;
}
