package com.wildcodeschool.traveldiary.repositories;

import com.wildcodeschool.traveldiary.entities.JourneyResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneyResourceRepository extends JpaRepository<JourneyResource, Integer> {
}
