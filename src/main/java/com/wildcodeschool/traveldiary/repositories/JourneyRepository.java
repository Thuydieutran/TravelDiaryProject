package com.wildcodeschool.traveldiary.repositories;

import com.wildcodeschool.traveldiary.entities.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneyRepository extends JpaRepository<Journey, Integer> {
}
