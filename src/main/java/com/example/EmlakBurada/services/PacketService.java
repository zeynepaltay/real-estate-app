package com.example.EmlakBurada.services;

import com.example.EmlakBurada.models.Packets;
import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import org.springframework.stereotype.Service;

@Service
public interface PacketService {
    Packets createPacket(PacketSaveRequest packets);

    Packets getPacket(Long id);

    Packets updatePacket(PacketSaveRequest packets);

    boolean deletePacket(PacketSaveRequest packets);
}
