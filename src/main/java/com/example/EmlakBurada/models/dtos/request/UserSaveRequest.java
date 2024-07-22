package com.example.EmlakBurada.models.dtos.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserSaveRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String userName; //belki gerekli değildir o zaman silerim
    private List<Long> packetId;
    private List<Long> advertId;
}
