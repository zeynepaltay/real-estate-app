package com.example.EmlakBurada.services.impl;

import com.example.EmlakBurada.mappers.AdvertMapper;
import com.example.EmlakBurada.models.ImageData;
import com.example.EmlakBurada.models.Users;
import com.example.EmlakBurada.models.dtos.request.AdvertSaveRequest;
import com.example.EmlakBurada.models.Adverts;
import com.example.EmlakBurada.models.Enums.AdvertStatus;
import com.example.EmlakBurada.models.dtos.response.AdvertResponse;
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
    private final AdvertMapper advertMapper;

    public List<AdvertResponse> getAllAdverts(){
        List<Adverts> result = advertRepository.findAll();
        if (result.isEmpty()) {
            throw new EntityNotFoundException("No adverts found in the system.");
        }

        return advertMapper.toResponseList(result);
    }

    public AdvertResponse createAdvert(AdvertSaveRequest request) {

        Users users = Optional.ofNullable(request.getUserId())
                .map(userService::getUser)
                .orElseThrow(()->new IllegalArgumentException("User id must not be null or invalid"));

        Users advertiser = Optional.ofNullable(request.getAdvertiserId())
                .map(userService::getUser)
                .orElseThrow(()-> new IllegalArgumentException("Advertiser id must not be null or invalid"));

        List<ImageData> imageDataList = Optional.ofNullable(request.getImageId())
                .map(imageDataService::findById)
                .orElse(Collections.emptyList());

        Adverts adverts = advertMapper.toAdvert(request);
        adverts.setUsers(users);
        adverts.setAdvertiser(advertiser);
        adverts.setImages(imageDataList);
        Adverts saved = advertRepository.save(adverts);
        return advertMapper.toResponse(saved);
    }

    public AdvertResponse updateAdvert(AdvertSaveRequest request) {
        Users users = Optional.ofNullable(request.getUserId())
                .map(userService::getUser)
                .orElseThrow(()-> new IllegalArgumentException("User id must not be null or invalid"));

        Users advertiser = Optional.ofNullable(request.getAdvertiserId())
                .map(userService::getUser)
                .orElseThrow(()-> new IllegalArgumentException("Advertiser id must not be null or invalid"));

        List<ImageData> imageDataList = Optional.ofNullable(request.getImageId())
                .map(imageDataService::findById)
                .orElse(Collections.emptyList());

        Adverts adverts = advertMapper.toAdvert(request);
        adverts.setUsers(users);
        adverts.setAdvertiser(advertiser);
        adverts.setImages(imageDataList);

        if (!imageDataList.isEmpty()) {
            adverts.setImages(imageDataList);
        }

        Adverts saved = advertRepository.save(adverts);
        return advertMapper.toResponse(saved);
    }

    public boolean deleteAdvert(Long id) {
        Adverts advert = advertRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Advert not found with id: " + id));

        advertRepository.delete(advert);
        return true;
    }

    public AdvertResponse getAdvert(Long id) {
        Adverts saved = advertRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Advert not found with id: " + id));
        return advertMapper.toResponse(saved);
    }

    public List<AdvertResponse> filterByAdvert(AdvertStatus advert) {
        if(advert == null){
            throw new IllegalArgumentException("Advert status must not be null");
        }

        List<Adverts> result = advertRepository.filterByAdvert(advert);
        return advertMapper.toResponseList(result);
    }

    public List<AdvertResponse> filterByBuyer(AdvertStatus status, String buyer) {
        if (status == null || buyer == null || buyer.isBlank()) {
            throw new IllegalArgumentException("Advert status and buyer must not be null or empty");
        }

        List<Adverts> result = advertRepository.filterByBuyer(status, buyer);
        return advertMapper.toResponseList(result);
    }
}
