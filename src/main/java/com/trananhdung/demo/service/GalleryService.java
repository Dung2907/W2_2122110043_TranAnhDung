package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.trananhdung.demo.entity.Gallery;

public interface GalleryService {
    Gallery saveImage(UUID productId, MultipartFile file,int i);
    List<Gallery> saveImages(UUID productId, MultipartFile[] files);
    List<Gallery> getImagesByProductId(UUID productId);
    void deleteGalleryByProductId(UUID productId);
    void update(UUID productId, MultipartFile[] newFiles);
}
