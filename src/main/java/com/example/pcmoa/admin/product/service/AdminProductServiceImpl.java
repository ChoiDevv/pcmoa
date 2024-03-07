package com.example.pcmoa.admin.product.service;

import com.example.pcmoa.product.entity.ProductImages;
import com.example.pcmoa.product.entity.ProductStatus;
import com.example.pcmoa.product.entity.Products;
import com.example.pcmoa.product.entity.repository.ProductImagesRepository;
import com.example.pcmoa.product.entity.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class AdminProductServiceImpl implements AdminProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImagesRepository productImagesRepository;

    // 파일 절대경로 불러오는 클래스 ResourceLoader | ChoiDevv
    private final ResourceLoader resourceLoader;
    public AdminProductServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Transactional
    @Override
    public void save(String name, String description, long price, String category, long stock, List<MultipartFile> images) throws IOException {
        // 상품 저장 | ChoiDevv
        Products products = productRepository.save(Products.toEntity(name, description, price, category, stock, ProductStatus.SELL));

        try {
            for (MultipartFile image: images) {

                String _imageName = StringUtils.cleanPath(image.getOriginalFilename());
                String path = System.getProperty("user.dir") + "/src/main/resources/static/image/product";
                String imageName = UUID.randomUUID() + "_" + _imageName;
                File file = new File(path, imageName);
                image.transferTo(file);

                // 이미지 저장 | ChoiDevv
                productImagesRepository.save(ProductImages.toEntity(imageName, products));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("이미지 저장에 실패하였습니다.");
        }
    }
}
