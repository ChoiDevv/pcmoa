package com.example.pcmoa.admin.product.service;

import com.example.pcmoa.product.entity.ProductStatus;
import com.example.pcmoa.product.entity.Products;
import com.example.pcmoa.admin.product.dto.AdminProductDto;
import com.example.pcmoa.product.entity.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminProductServiceImpl implements AdminProductService {

    private final ProductRepository productRepository;

    @Transactional
    @Override
    public void save(AdminProductDto adminProductDto) {
        ProductStatus status = ProductStatus.SELL;
        productRepository.save(Products.toEntity(adminProductDto, status));
    }
}
