package com.example.EmlakBurada.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "packets")
public class Packets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "packets", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adverts> adverts;//burda twist var bi daha bak ilan zamanlarıyla ilgili

    @Column(name = "num_of_ad_right")
    private Integer numOfAdRight;// kaç ilan yayınlama hakkı kaldı onun sayısı

    @Column(name = "time_left_to_end")
    private Integer timeLeftToEnd;// paketin bitmesine  kaç gün süre kaldı

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;



}
