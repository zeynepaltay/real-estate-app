package com.example.EmlakBurada.services;

import com.example.EmlakBurada.models.ImageData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ImageDataService {

    ImageData uploadImage(MultipartFile file) throws IOException;

    ImageData getInfoByImageByName(String name);

    boolean deleteImage(Long id);

    byte[] getImage(String name);

    List<ImageData> findById(List<Long> ids);
}
