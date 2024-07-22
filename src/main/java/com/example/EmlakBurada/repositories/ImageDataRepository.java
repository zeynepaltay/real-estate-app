package com.example.EmlakBurada.repositories;

import com.example.EmlakBurada.models.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ImageDataRepository extends JpaRepository<ImageData, Long> {
    @Query("SELECT i FROM ImageData i WHERE (:name IS NULL OR i.name = :name)")
    Optional<ImageData> findByName(@Param("name") String name);

    List<ImageData> findByIdIn(List<Long> ids);
}
