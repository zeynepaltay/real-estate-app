package com.example.EmlakBurada.mappers;

import com.example.EmlakBurada.models.Adverts;
import com.example.EmlakBurada.models.dtos.request.AdvertSaveRequest;
import com.example.EmlakBurada.models.dtos.response.AdvertResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdvertMapper {
    @Mapping(target ="users", ignore =true)
    @Mapping(target = "advertiser", ignore =true)
    @Mapping(target = "images", ignore = true)
    Adverts toAdvert(AdvertSaveRequest request);

    @Mapping(source = "furnished", target = "furnished", qualifiedByName = "booleanToYesNo")
    @Mapping(source = "advertiser.name", target = "advertiser") // advertiser objesinin adı alınacak
    @Mapping(source = "buyerId", target = "buyerid")
    AdvertResponse toResponse(Adverts advert);

    List<AdvertResponse> toResponseList(List<Adverts> adverts);
}
