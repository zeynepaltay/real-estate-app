package com.example.EmlakBurada.services.impl;

import com.example.EmlakBurada.mappers.PacketMapper;
import com.example.EmlakBurada.models.Packets;
import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import com.example.EmlakBurada.models.dtos.response.PacketResponse;
import com.example.EmlakBurada.services.PacketService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.EmlakBurada.repositories.PacketRepository;
@RequiredArgsConstructor
@Service
public class PacketServiceImpl implements PacketService {

    private final PacketRepository packetRepository;
    private final PacketMapper packetMapper;

    public PacketResponse createPacket(PacketSaveRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Packet request must not be null.");
        }

        Packets packets = packetMapper.toPacket(request);
        Packets saved = packetRepository.save(packets);
        return packetMapper.toPacketResponse(saved);
    }

    @Override
    public PacketResponse getPacket(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Packet ID must not be null.");
        }

        Packets packets = packetRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Packet not found with id: " + id));

        return packetMapper.toPacketResponse(packets);
    }

    @Override
    public PacketResponse updatePacket(PacketSaveRequest request) {
        if (request == null || request.getAdvertId() == null) {
            throw new IllegalArgumentException("Packet ID must not be null for update.");
        }

        if (!packetRepository.existsById(request.getAdvertId())) {
            throw new EntityNotFoundException("Packet not found with id: " + request.getAdvertId());
        }

        Packets packets = packetMapper.toPacket(request);
        Packets saved = packetRepository.save(packets);
        return packetMapper.toPacketResponse(saved);
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
