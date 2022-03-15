package com.wildcodeschool.traveldiary.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Destination implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer id;
    private String destinationName;

    @Temporal(TemporalType.DATE)
    private Date destinationStart;

    @Temporal(TemporalType.DATE)
    private Date destinationEnd;

    @Column(nullable = false, updatable = false)
    private String country;

    @OneToMany(mappedBy = "destination")
    @JsonManagedReference
    private final List<Journey> journeyList = new ArrayList<>();


    public Destination() {}

    public Destination(String destinationName, Date destinationStart, Date destinationEnd, String country) {
        this.destinationName = destinationName;
        this.destinationStart = destinationStart;
        this.destinationEnd = destinationEnd;
        this.country = country;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Journey> getJourneyList() {
        return journeyList;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Date getDestinationStart() {
        return destinationStart;
    }

    public void setDestinationStart(Date destinationStart) {
        this.destinationStart = destinationStart;
    }

    public Date getDestinationEnd() {
        return destinationEnd;
    }

    public void setDestinationEnd(Date destinationEnd) {
        this.destinationEnd = destinationEnd;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", destinationName='" + destinationName + '\'' +
                ", destinationStart=" + destinationStart +
                ", destinationEnd=" + destinationEnd +
                ", country='" + country + '\'' +
                ", journeyList=" + journeyList +
                '}';
    }
}
