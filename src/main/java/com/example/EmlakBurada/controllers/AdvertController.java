package com.example.EmlakBurada.controllers;

import com.example.EmlakBurada.models.Adverts;
import com.example.EmlakBurada.models.Enums.AdvertStatus;
import com.example.EmlakBurada.models.dtos.request.AdvertSaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.EmlakBurada.services.AdvertService;

import java.util.List;

@RestController
    @RequestMapping("/api/v1/advert")
@CrossOrigin(origins = "http://localhost:3000")
public class AdvertController {
    AdvertService advertService;
    @Autowired
    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }
    @GetMapping
    public List<Adverts> getAllAdverts(){
        return advertService.getAllAdverts();
    }

    @PostMapping("/createadvert")
    public Adverts createAdvert(@RequestBody AdvertSaveRequest adverts){
        return advertService.createAdvert(adverts);
    }
    @PutMapping("/updateadvert")
    public Adverts updateAdvert(@RequestParam("adverts") AdvertSaveRequest adverts){
        return advertService.updateAdvert(adverts);
    }

    @DeleteMapping("/deleteadvert")
    public Boolean deleteAdvert(@RequestParam("id") Long id){
        return advertService.deleteAdvert(id);//burda sildim silemedim falan diye dönüş lazım
    }
    @GetMapping("/getadvert")
    public Adverts getAdvert(@RequestParam("id") Long id){
        return advertService.getAdvert(id);
    }
    @GetMapping("/search")
    public List<Adverts> searchAdvert(@RequestParam("adverts") AdvertStatus adverts) {
        return advertService.filterByAdvert(adverts);
    }
    @GetMapping("/searchbuyer")
    public List<Adverts> searchAdverts(@RequestParam("status") AdvertStatus status,
                                      @RequestParam("buyer") String buyer) {
        return advertService.filterByBuyer(status, buyer);
    }
//    @GetMapping("/No")
//    public Adverts getNoAdvert(@RequestParam("advertNo") Long advertNo){
//        return advertService.getAdvert(advertNo);
//    }
}
