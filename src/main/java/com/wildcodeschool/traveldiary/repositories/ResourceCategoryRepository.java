package com.wildcodeschool.traveldiary.repositories;

import com.wildcodeschool.traveldiary.entities.ResourceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceCategoryRepository extends JpaRepository<ResourceCategory, Integer> {
}
