package com.example.EmlakBurada.services;

import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import com.example.EmlakBurada.models.dtos.response.PacketResponse;
import org.springframework.stereotype.Service;

@Service
public interface PacketService {
    PacketResponse createPacket(PacketSaveRequest packets);

    PacketResponse getPacket(Long id);

    PacketResponse updatePacket(PacketSaveRequest packets);

    boolean deletePacket(PacketSaveRequest packets);
}
