package com.example.EmlakBurada.models.dtos.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AdvertSearchRequest {
    private String address;
    private Double price;
    private Integer advertNo;
    private LocalDateTime advertDate;
    private Integer bath;
    private Double ruler;
    private String realEstateType;//enum yapilcak
    //m² (Brüt), m² (Net) için yazılacak
    private Integer numOfRooms;
    private Integer buildingAge;
    private Integer floorLevel;
    private Integer numOfFloors;
    private String heating;
    private Boolean furnished;
    private Long advertiserId; // who gave the advert
    private Long userId;
    private Boolean paymentReceived;
    private Long buyerId;
}
