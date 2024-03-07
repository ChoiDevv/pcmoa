package com.example.pcmoa.product.service;

import com.example.pcmoa.product.entity.ProductImages;
import com.example.pcmoa.product.entity.ProductStatus;
import com.example.pcmoa.product.entity.dto.ProductsDto;
import com.example.pcmoa.product.entity.repository.ProductImagesRepository;
import com.example.pcmoa.product.entity.repository.ProductRepository;
import com.example.pcmoa.product.entity.repository.querydsl.DslProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final DslProductRepository dslProductRepository;

    @Override
    public List<ProductsDto> index() {
        return ProductsDto.transformation(dslProductRepository.findAllProductsWithImages());
    }
}
