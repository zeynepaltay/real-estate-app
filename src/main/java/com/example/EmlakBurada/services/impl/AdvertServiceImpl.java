package com.example.EmlakBurada.services.impl;

import com.example.EmlakBurada.converter.AdvertConverter;
import com.example.EmlakBurada.models.ImageData;
import com.example.EmlakBurada.models.Users;
import com.example.EmlakBurada.models.dtos.request.AdvertSaveRequest;
import com.example.EmlakBurada.models.Adverts;
import com.example.EmlakBurada.models.Enums.AdvertStatus;
import com.example.EmlakBurada.repositories.AdvertRepository;
import com.example.EmlakBurada.services.AdvertService;
import com.example.EmlakBurada.services.ImageDataService;
import com.example.EmlakBurada.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdvertServiceImpl implements AdvertService {
    private final ImageDataService imageDataService;
    private final AdvertRepository advertRepository;
    private final UserService userService;

    public List<Adverts> getAllAdverts(){
        List<Adverts> result = advertRepository.findAll();

        if (result.isEmpty()) {
            throw new EntityNotFoundException("No adverts found in the system.");
        }

        return result;
    }

    public Adverts createAdvert(AdvertSaveRequest request) {

        Users users = Optional.ofNullable(request.getUserId())
                .map(userService::getUser)
                .orElseThrow(()->new IllegalArgumentException("User id must not be null or invalid"));

        Users advertiser = Optional.ofNullable(request.getAdvertiserId())
                .map(userService::getUser)
                .orElseThrow(()-> new IllegalArgumentException("Advertiser id must not be null or invalid"));

        List<ImageData> imageDataList = Optional.ofNullable(request.getImageId())
                .map(imageDataService::findById)
                .orElse(Collections.emptyList());

        Adverts adverts = AdvertConverter.toAdvert(request, users, advertiser);
        adverts.setImages(imageDataList);
        return advertRepository.save(adverts);
    }

    public Adverts updateAdvert(AdvertSaveRequest request) {
        Users users = Optional.ofNullable(request.getUserId())
                .map(userService::getUser)
                .orElseThrow(()-> new IllegalArgumentException("User id must not be null or invalid"));

        Users advertisers = Optional.ofNullable(request.getAdvertiserId())
                .map(userService::getUser)
                .orElseThrow(()-> new IllegalArgumentException("Advertiser id must not be null or invalid"));

        List<ImageData> imageDataList = Optional.ofNullable(request.getImageId())
                .map(imageDataService::findById)
                .orElse(Collections.emptyList());

        Adverts adverts = AdvertConverter.toAdvert(request, users, advertisers);

        if (!imageDataList.isEmpty()) {
            adverts.setImages(imageDataList);
        }

        return advertRepository.save(adverts);
    }

    public boolean deleteAdvert(Long id) {
        Adverts advert = advertRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Advert not found with id: " + id));

        advertRepository.delete(advert);
        return true;
    }

    public Adverts getAdvert(Long id) {
        return advertRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Advert not found with id: " + id));
    }

    public List<Adverts> filterByAdvert(AdvertStatus advert) {
        if(advert == null){
            throw new IllegalArgumentException("Advert status must not be null");
        }

        return advertRepository.filterByAdvert(advert);
    }

    public List<Adverts> filterByBuyer(AdvertStatus status, String buyer) {
        if (status == null || buyer == null || buyer.isBlank()) {
            throw new IllegalArgumentException("Advert status and buyer must not be null or empty");
        }

        return advertRepository.filterByBuyer(status, buyer);
    }
}
