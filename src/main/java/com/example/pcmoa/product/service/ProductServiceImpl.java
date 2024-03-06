package com.example.pcmoa.product.service;

import com.example.pcmoa.product.entity.ProductImages;
import com.example.pcmoa.product.entity.ProductStatus;
import com.example.pcmoa.product.entity.dto.ProductsDto;
import com.example.pcmoa.product.entity.repository.ProductImagesRepository;
import com.example.pcmoa.product.entity.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductsDto> index() {
        ProductStatus status = ProductStatus.SELL;
        return ProductsDto.transformation(productRepository.findAllByProductStatusAndStockNot(status, BigDecimal.ZERO));
    }
}
