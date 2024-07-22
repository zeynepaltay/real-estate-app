package com.example.EmlakBurada.services;

import com.example.EmlakBurada.models.Packets;
import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import com.example.EmlakBurada.converter.PacketConverter;
import com.example.EmlakBurada.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.EmlakBurada.repositories.PacketRepository;
@RequiredArgsConstructor
@Service
public class PacketService {
    PacketRepository packetRepository;
    public PacketService(PacketRepository packetRepository) {
        this.packetRepository = packetRepository;
    }

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
