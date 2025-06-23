package com.example.EmlakBurada.controllers;

import com.example.EmlakBurada.models.Packets;
import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import com.example.EmlakBurada.services.PacketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/packet")
public class PacketController {

    private final PacketService packetService;

    @PostMapping("/createpacket")
    public Packets createPacket(@RequestParam("packet") PacketSaveRequest packets){
        return packetService.createPacket(packets);
    }

    @GetMapping("/getpacket")
    public Packets getPacket(@RequestParam("id") Long id){
        return packetService.getPacket(id);
    }

    @PutMapping("/updatepacket")
    public Packets updatePacket(@RequestParam("packets") PacketSaveRequest packets){
        return packetService.updatePacket(packets);
    }

    @DeleteMapping("/deletepacket")
    public boolean deletePacket(@RequestParam("packets") PacketSaveRequest packets){
        return packetService.deletePacket(packets);
    }
}
