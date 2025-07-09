package com.example.EmlakBurada.mappers;

import com.example.EmlakBurada.models.Packets;
import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import com.example.EmlakBurada.models.dtos.response.PacketResponse;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PacketMapper {
    Packets toPacket(PacketSaveRequest request);

    PacketResponse toPacketResponse(Packets packet);
}
