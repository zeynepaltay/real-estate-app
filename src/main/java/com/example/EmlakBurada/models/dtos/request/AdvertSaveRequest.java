package com.example.EmlakBurada.models.dtos.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AdvertSaveRequest {
    private String address;
    private String details; //details of the advert, sonra yazasım gelfi ya
    private Double price;
    private Integer advertNo;
    private Integer advertDate;
    private Integer bath;
    private Double ruler;
    private String realEstateType;
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
    private List<Long> imageId;
}
