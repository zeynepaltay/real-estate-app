package com.example.EmlakBurada.services;

import com.example.EmlakBurada.models.Enums.AdvertStatus;
import com.example.EmlakBurada.models.dtos.request.AdvertSaveRequest;
import com.example.EmlakBurada.models.dtos.response.AdvertResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AdvertService {

    List<AdvertResponse> getAllAdverts();

    AdvertResponse createAdvert(AdvertSaveRequest adverts);

    AdvertResponse updateAdvert(AdvertSaveRequest adverts);

    boolean deleteAdvert(Long id);

    AdvertResponse getAdvert(Long id);

    List<AdvertResponse> filterByAdvert(AdvertStatus advert);

    List<AdvertResponse> filterByBuyer(AdvertStatus status, String buyer);
}
