package com.example.EmlakBurada.controllers;

import com.example.EmlakBurada.models.Packets;
import com.example.EmlakBurada.models.dtos.request.PacketSaveRequest;
import com.example.EmlakBurada.services.PacketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/packet")
public class PacketController {

    private final PacketService packetService;

    @PostMapping("/create-packet")
    public ResponseEntity<Packets> createPacket(@RequestParam PacketSaveRequest packets){
        return ResponseEntity.ok(packetService.createPacket(packets));
    }

    @GetMapping("/get-packet")
    public ResponseEntity<Packets> getPacket(@RequestParam Long id){
        return ResponseEntity.ok(packetService.getPacket(id));
    }

    @PutMapping("/update-packet")
    public ResponseEntity<Packets> updatePacket(@RequestParam PacketSaveRequest packets){
        return ResponseEntity.ok(packetService.updatePacket(packets));
    }

    @DeleteMapping("/delete-packet")
    public ResponseEntity<Boolean> deletePacket(@RequestParam PacketSaveRequest packets) {
        boolean result = packetService.deletePacket(packets);
        if (result) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
