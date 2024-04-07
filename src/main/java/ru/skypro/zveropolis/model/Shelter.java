package ru.skypro.zveropolis.model;

public enum Shelter {
    SHELTER_CAT ("kjdfsfn,v ","jhbvhdsbvgh","nbv hdmfvb"),     SHELTER_DOG ("kjsfn,v ","jbvgh","nbv h625352mfvb");

    Shelter(String information, String address, String roadmap) {
        this.information = information;
        this.address = address;
        this.roadmap = roadmap;
    }

    private String information;


    private String address;


    private String roadmap;



}
