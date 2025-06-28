package com.example.EmlakBurada.services.impl;

import com.example.EmlakBurada.models.Packets;
import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import com.example.EmlakBurada.converter.PacketConverter;
import com.example.EmlakBurada.services.PacketService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.EmlakBurada.repositories.PacketRepository;
@RequiredArgsConstructor
@Service
public class PacketServiceImpl implements PacketService {

    private final PacketRepository packetRepository;

    public Packets createPacket(PacketSaveRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Packet request must not be null.");
        }

        Packets packets = PacketConverter.toPacket(request);
        return packetRepository.save(packets);
    }

    @Override
    public Packets getPacket(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Packet ID must not be null.");
        }

        return packetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Packet not found with id: " + id));
    }

    @Override
    public Packets updatePacket(PacketSaveRequest request) {
        if (request == null || request.getAdvertId() == null) {
            throw new IllegalArgumentException("Packet ID must not be null for update.");
        }

        if (!packetRepository.existsById(request.getAdvertId())) {
            throw new EntityNotFoundException("Packet not found with id: " + request.getAdvertId());
        }

        Packets packets = PacketConverter.toPacket(request);
        return packetRepository.save(packets);
    }

    @Override
    public boolean deletePacket(PacketSaveRequest request) {
        if (request == null || request.getAdvertId() == null) {
            throw new IllegalArgumentException("Packet ID must not be null for delete.");
        }

        if (!packetRepository.existsById(request.getAdvertId())) {
            throw new EntityNotFoundException("Packet not found with id: " + request.getAdvertId());
        }

        packetRepository.deleteById(request.getAdvertId());
        return true;
    }
}
