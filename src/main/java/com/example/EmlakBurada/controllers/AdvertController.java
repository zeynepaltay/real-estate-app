package com.example.EmlakBurada.controllers;

import com.example.EmlakBurada.models.Adverts;
import com.example.EmlakBurada.models.Enums.AdvertStatus;
import com.example.EmlakBurada.models.dtos.request.AdvertSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.EmlakBurada.services.AdvertService;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/advert")
@CrossOrigin(origins = "http://localhost:3000")
public class AdvertController {

    private final AdvertService advertService;

    @GetMapping
    public ResponseEntity<List<Adverts>> getAllAdverts() {
        return ResponseEntity.ok(advertService.getAllAdverts());
    }

    @PostMapping("/create-advert")
    public ResponseEntity<Adverts> createAdvert(@RequestBody AdvertSaveRequest adverts) {
        return ResponseEntity.ok(advertService.createAdvert(adverts));
    }

    @PutMapping("/update-advert")
    public ResponseEntity<Adverts> updateAdvert(@RequestParam("adverts") AdvertSaveRequest adverts) {
        return ResponseEntity.ok(advertService.updateAdvert(adverts));
    }

    @DeleteMapping("/delete-advert")
    public ResponseEntity<Boolean> deleteAdvert(@RequestParam Long id) {
        return ResponseEntity.ok(advertService.deleteAdvert(id));
    }

    @GetMapping("/get-advert")
    public ResponseEntity<Adverts> getAdvert(@RequestParam Long id) {
        return ResponseEntity.ok(advertService.getAdvert(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Adverts>> searchAdvert(@RequestParam AdvertStatus adverts) {
        return ResponseEntity.ok(advertService.filterByAdvert(adverts));
    }

    @GetMapping("/search-buyer")
    public ResponseEntity<List<Adverts>> searchAdverts(@RequestParam AdvertStatus status,
                                       @RequestParam String buyer) {
        return ResponseEntity.ok(advertService.filterByBuyer(status, buyer));
    }
}
