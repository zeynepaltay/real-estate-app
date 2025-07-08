package com.example.EmlakBurada.models;

import com.example.EmlakBurada.models.Enums.AdvertStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "adverts")
public class Adverts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private AdvertStatus status;

    @Column(name = "details")
    private String details;

    @Column(name = "price")
    private Double price;

    @Column(name = "advert_no")
    private Integer advertNo;

    @Column(name = "advert_date")
    private LocalDateTime advertDate;

    @Column(name = "real_estate_type")
    private String realEstateType;//enum yapilcak
    //m² (Brüt), m² (Net) için yazılacak

    @Column(name = "num_of_rooms")
    private Integer numOfRooms;

    @Column(name = "building_age")
    private Integer buildingAge;

    @Column(name = "floor_level")
    private Integer floorLevel;

    @Column(name = "num_of_floors")
    private Integer numOfFloors;

    @Column(name = "heating")
    private String heating;

    @Column(name = "bath")
    private String bath;

    @Column(name = "ruler")
    private String ruler;

    @Column(name = "furnished")
    private Boolean furnished;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertiser_id")
    @JsonIgnore
    private Users advertiser;// who gave the advert

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", nullable = true)
    private Users users;

    @Column(name = "payment_recieved")
    private Boolean paymentReceived;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id", nullable = true)
    private Users buyer;

    @ManyToOne
    @JoinColumn(name = "packets_id, nullable = true")
    private Packets packets;

    @OneToMany(mappedBy = "adverts", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ImageData> images;
}
