package com.example.EmlakBurada.services.impl;

import com.example.EmlakBurada.converter.AdvertConverter;
import com.example.EmlakBurada.models.ImageData;
import com.example.EmlakBurada.models.Users;
import com.example.EmlakBurada.models.dtos.request.AdvertSaveRequest;
import com.example.EmlakBurada.models.Adverts;
import com.example.EmlakBurada.models.Enums.AdvertStatus;
import com.example.EmlakBurada.repositories.AdvertRepository;
import com.example.EmlakBurada.services.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdvertServiceImpl implements AdvertService {
    private final ImageDataServiceImpl imageDataService;
    private final AdvertRepository advertRepository;
    private final UserServiceImpl userService;

    public List<Adverts> getAllAdverts(){
        List<Adverts> result = advertRepository.findAll();
        return result;
    }

    public Adverts createAdvert(AdvertSaveRequest adverts) {
        Users users = null;
        Users advertiser = null;
        List<ImageData> imageData = null;

        if(adverts.getUserId() != null){
            users = userService.getUser(adverts.getUserId());
        }

        if(adverts.getAdvertiserId() != null){
            advertiser = userService.getUser(adverts.getAdvertiserId());
        }

        if(adverts.getImageId() != null){
            imageData = imageDataService.findById(adverts.getImageId());
        }

        Adverts adverts1 = AdvertConverter.toAdvert(adverts,users,advertiser);
        return advertRepository.save(adverts1);
    }

    public Adverts updateAdvert(AdvertSaveRequest adverts) {
        Users users = null;
        Users advertisers = null;
        List<ImageData> imageData = null;

        if(adverts.getUserId() != null){
            users = userService.getUser(adverts.getUserId());
        }

        if(adverts.getAdvertiserId() !=null){
            advertisers = userService.getUser(adverts.getAdvertiserId());
        }

        if(adverts.getImageId() !=null){
            imageData = imageDataService.findById(adverts.getImageId());
        }

        Adverts adverts1 = AdvertConverter.toAdvert(adverts,users,advertisers);

        return advertRepository.save(adverts1);
    }

    public boolean deleteAdvert(Long id) {
        Optional<Adverts> advert = advertRepository.findById(id);

        if (advert.isPresent()) {
            advertRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Adverts getAdvert(Long id) {
        return advertRepository.findById(id).get();
    }

    public List<Adverts> filterByAdvert(AdvertStatus advert) {
        return advertRepository.filterByAdvert(advert);
    }

    public List<Adverts> filterByBuyer(AdvertStatus status, String buyer) {
        return advertRepository.filterByBuyer(status, buyer);
    }
}
