package com.example.EmlakBurada.models.dtos.response;

import com.example.EmlakBurada.models.Adverts;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PacketResponse {
    private Adverts adverts;//burda twist var bi daha bak ilan zamanlarıyla ilgili
    private Integer numOfAdRight;// kaç ilan yayınlama hakkı kaldı onun sayısı
    private Integer timeLeftToEnd;// paketin bitmesine  kaç gün süre kaldı
}
