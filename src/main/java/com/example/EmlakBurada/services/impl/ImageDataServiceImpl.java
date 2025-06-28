package com.example.EmlakBurada.services.impl;


import com.example.EmlakBurada.models.ImageData;
import com.example.EmlakBurada.ImageUtil;
import com.example.EmlakBurada.repositories.ImageDataRepository;
import com.example.EmlakBurada.services.ImageDataService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageDataServiceImpl implements ImageDataService {
    private final ImageDataRepository imageDataRepository;

    @Transactional
    public ImageData uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .build();

        return imageDataRepository.save(imageData);
    }

    @Transactional
    public ImageData getInfoByImageByName(String name) {
        ImageData dbImage = imageDataRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Image not found with name: " + name));

        return ImageData.builder()
                .name(dbImage.getName())
                .type(dbImage.getType())
                .imageData(ImageUtil.decompressImage(dbImage.getImageData()))
                .build();
    }

    @Transactional
    public boolean deleteImage(Long id) {
        if (!imageDataRepository.existsById(id)) {
            throw new EntityNotFoundException("Image not found with id: " + id);
        }

        imageDataRepository.deleteById(id);
        return true;
    }

    @Transactional
    public byte[] getImage(String name) {
        ImageData dbImage = imageDataRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Image not found with name: " + name));

        return ImageUtil.decompressImage(dbImage.getImageData());
    }

    @Transactional
    public List<ImageData> findById(List<Long> ids) {
        List<ImageData> dbImages = imageDataRepository.findByIdIn(ids);

        if (dbImages.isEmpty()) {
            throw new EntityNotFoundException("No images found for provided IDs.");
        }

        return dbImages.stream().map(dbImage -> ImageData.builder()
                        .name(dbImage.getName())
                        .type(dbImage.getType())
                        .imageData(ImageUtil.decompressImage(dbImage.getImageData()))
                        .build())
                .collect(Collectors.toList());
    }
}