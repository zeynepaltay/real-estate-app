package com.example.EmlakBurada.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "image_data")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @Lob
    @Column(name = "imagedata", length = 1000)
    private byte[] imageData;

    @ManyToOne
    @JoinColumn(name = "adverts_id")
    private Packets advertes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advert_id")
    private Adverts adverts;
}
