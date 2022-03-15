package com.wildcodeschool.traveldiary.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Journey implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String city;
    private LocalDate journeyDate;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @ManyToOne
    @JsonBackReference
    private Destination destination;

    @OneToMany(mappedBy ="journey")
    @JsonManagedReference
    private final List<JourneyResource> journeyResources = new ArrayList<>();

    public Journey() {
    }

    public Journey(String city, LocalDate journeyDate, String summary, Destination destination) {
        this.city = city;
        this.journeyDate = journeyDate;
        this.summary = summary;
        this.destination = destination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public List<JourneyResource> getJourneyResources() {
        return journeyResources;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", journeyDate=" + journeyDate +
                ", summary='" + summary + '\'' +
                ", destination=" + destination +
                ", journeyResources=" + journeyResources +
                '}';
    }
}
