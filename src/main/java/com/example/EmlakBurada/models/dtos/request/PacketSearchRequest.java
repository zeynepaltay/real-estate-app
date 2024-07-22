package com.example.EmlakBurada.models.dtos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PacketSearchRequest {
    private Long advertId;//burda twist var bi daha bak ilan zamanlarıyla ilgili
    private Integer numOfAdRight;// kaç ilan yayınlama hakkı kaldı onun sayısı
    private Integer timeLeftToEnd;// paketin bitmesine  kaç gün süre kaldı
    private Long packetId;
}
