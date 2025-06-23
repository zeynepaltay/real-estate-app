package com.example.EmlakBurada.services;

import com.example.EmlakBurada.models.Adverts;
import com.example.EmlakBurada.models.Enums.AdvertStatus;
import com.example.EmlakBurada.models.dtos.request.AdvertSaveRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AdvertService {

    List<Adverts> getAllAdverts();

    Adverts createAdvert(AdvertSaveRequest adverts);

    Adverts updateAdvert(AdvertSaveRequest adverts);

    boolean deleteAdvert(Long id);

    Adverts getAdvert(Long id);

    List<Adverts> filterByAdvert(AdvertStatus advert);

    List<Adverts> filterByBuyer(AdvertStatus status, String buyer);
}
