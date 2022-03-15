package com.wildcodeschool.traveldiary.repositories;

import com.wildcodeschool.traveldiary.entities.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DestinationRepository extends JpaRepository<Destination, Integer> {
    @Query("SELECT d FROM Destination d WHERE d.country like :x")
    public Page<Destination> search(@Param("x") String keyword, Pageable pageable);
}
