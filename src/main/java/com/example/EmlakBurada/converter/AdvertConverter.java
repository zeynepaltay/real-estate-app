package com.example.EmlakBurada.converter;

import com.example.EmlakBurada.models.Adverts;
import com.example.EmlakBurada.models.Users;
import com.example.EmlakBurada.models.dtos.request.AdvertSaveRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdvertConverter {
    public static Adverts toAdvert(AdvertSaveRequest request, Users users, Users advertiser){
        return Adverts.builder()
                .details(request.getDetails())
                .price(request.getPrice())
                .advertNo(request.getAdvertNo())
                .advertDate(request.getAdvertDate())
                .realEstateType(request.getRealEstateType())
                .numOfRooms(request.getNumOfRooms())
                .buildingAge(request.getBuildingAge())
                .floorLevel(request.getFloorLevel())
                .numOfFloors(request.getNumOfFloors())
                .heating(request.getHeating())
                .furnished(request.getFurnished())
                .advertiser(advertiser)
                .users(users)
                .build();
    }
}
