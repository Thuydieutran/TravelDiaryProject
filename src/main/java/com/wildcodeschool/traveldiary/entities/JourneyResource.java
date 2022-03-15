package com.wildcodeschool.traveldiary.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class JourneyResource implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private ResourceCategory category;

    private String resourceUrl;

    @ManyToOne
    @JsonBackReference
    private Journey journey;

    public JourneyResource() {
    }

    public JourneyResource(ResourceCategory category, String resourceUrl, Journey journey) {
        this.category = category;
        this.resourceUrl = resourceUrl;
        this.journey = journey;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResourceCategory getCategory() {
        return category;
    }

    public void setCategory(ResourceCategory category) {
        this.category = category;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public String toString() {
        return "JourneyResource{" +
                "id=" + id +
                ", category=" + category +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", journey=" + journey +
                '}';
    }
}
