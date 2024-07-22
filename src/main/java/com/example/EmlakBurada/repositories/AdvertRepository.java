package com.example.EmlakBurada.repositories;

import com.example.EmlakBurada.models.Adverts;
import com.example.EmlakBurada.models.Enums.AdvertStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<Adverts, Long> {
    // @Query anotasyonu ile
    @Query("SELECT i FROM Adverts i WHERE (:status IS NULL OR i.status = :status)")
    List<Adverts> filterByAdvert(@Param("status") AdvertStatus adverts);

    @Query("SELECT a FROM Adverts a WHERE (:status IS NULL OR a.status = :status) AND (:buyer IS NULL OR a.buyer = :buyer)")
    List<Adverts> filterByBuyer(@Param("status") AdvertStatus status, @Param("buyer") String buyer);

    Adverts getAdvertNo(Long advertNo);
}


