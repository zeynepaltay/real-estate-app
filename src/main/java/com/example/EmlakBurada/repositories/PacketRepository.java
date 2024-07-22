package com.example.EmlakBurada.repositories;

import com.example.EmlakBurada.models.Packets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacketRepository extends JpaRepository<Packets, Long> {
}
