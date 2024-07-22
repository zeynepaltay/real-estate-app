package com.example.EmlakBurada.converter;

import com.example.EmlakBurada.models.Packets;
import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PacketConverter {
    public static Packets toPacket(PacketSaveRequest request){
            return Packets.builder()
                .numOfAdRight(request.getNumOfAdRight())
                .timeLeftToEnd(request.getTimeLeftToEnd())
                    .build();
    }
}
