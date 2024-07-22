package com.example.EmlakBurada.models.dtos.response;

import com.example.EmlakBurada.models.Adverts;
import com.example.EmlakBurada.models.Packets;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserResponse {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String userName; //belki gerekli değildir o zaman silerim
    private Adverts adverts; //zaten paketin içinde de var bu
    private Packets packets;
}

