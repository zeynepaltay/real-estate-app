package com.example.EmlakBurada.services.impl;


import com.example.EmlakBurada.models.ImageData;
import com.example.EmlakBurada.ImageUtil;
import com.example.EmlakBurada.repositories.ImageDataRepository;
import com.example.EmlakBurada.services.ImageDataService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageDataServiceImpl implements ImageDataService {
    private final ImageDataRepository imageDataRepository;

    @Transactional
    public ImageData uploadImage(MultipartFile file) throws IOException {

        ImageData response=imageDataRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());
        return response;
    }

    @Transactional
    public ImageData getInfoByImageByName(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);

        return ImageData.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();
    }

    @Transactional
    public boolean deleteImage(Long id) {
        imageDataRepository.deleteById(id);
        return true;
    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);
        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
        return image;
    }

    @Transactional
    public List<ImageData> findById(List<Long> ids) {
        List<ImageData> dbImages = imageDataRepository.findByIdIn(ids);
        return dbImages.stream().map(dbImage -> ImageData.builder()
                        .name(dbImage.getName())
                        .type(dbImage.getType())
                        .imageData(ImageUtil.decompressImage(dbImage.getImageData()))
                        .build())
                .collect(Collectors.toList());
    }
}