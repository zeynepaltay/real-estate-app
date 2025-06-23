package com.example.EmlakBurada.services.impl;

import com.example.EmlakBurada.models.Packets;
import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import com.example.EmlakBurada.converter.PacketConverter;
import com.example.EmlakBurada.services.PacketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.EmlakBurada.repositories.PacketRepository;
@RequiredArgsConstructor
@Service
public class PacketServiceImpl implements PacketService {

    private final PacketRepository packetRepository;

    public Packets createPacket(PacketSaveRequest packets) {
        Packets packets1 = PacketConverter.toPacket(packets);
        return packetRepository.save(packets1);
    }

    public Packets getPacket(Long id) {
        return packetRepository.getById(id);
    }

    public Packets updatePacket(PacketSaveRequest packets) {
        Packets packets1 = PacketConverter.toPacket(packets);
        return packetRepository.save(packets1);
    }

    public boolean deletePacket(PacketSaveRequest packets) {
        Packets packets1 = PacketConverter.toPacket(packets);
        packetRepository.deleteById(packets1.getId());
        return true;
    }
}
