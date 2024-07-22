package com.example.EmlakBurada.controllers;

import com.example.EmlakBurada.models.Packets;
import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.EmlakBurada.services.PacketService;

@RestController
@RequestMapping("/api/v1/packet")
public class PacketController {
    PacketService packetService;
    @Autowired
    public PacketController(PacketService packetService) {
        this.packetService = packetService;
    }
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
