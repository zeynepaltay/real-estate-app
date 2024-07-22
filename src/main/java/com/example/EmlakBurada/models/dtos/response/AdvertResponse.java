package com.example.EmlakBurada.models.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AdvertResponse {
    private String details; //details of the advert, sonra yazasım gelfi ya
    private Double price;
    private Integer advertNo;
    private Integer advertDate;
    private String realEstateType;//enum yapilcak
    //m² (Brüt), m² (Net) için yazılacak
    private Integer numOfRooms;
    private Integer buildingAge;
    private Integer floorLevel;
    private Integer numOfFloors;
    private String heating;
    private String furnished;
    private String advertiser; // who gave the advert
    private Boolean paymentReceived;
    private Long buyerid;
}
