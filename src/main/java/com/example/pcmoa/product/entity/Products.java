package com.example.pcmoa.product.entity;

import com.example.pcmoa.config.entity.BaseEntity;
import com.example.pcmoa.product.entity.dto.ProductDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "pcmoa_products")
public class Products extends BaseEntity {

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @Column
    private String category;

    @Column
    private BigDecimal stock;

    @Enumerated(value = EnumType.STRING)
    @Column
    private ProductStatus productStatus;

    @Column
    private Long hits;

    @Builder
    public Products(String name, String description, BigDecimal price, String category, BigDecimal stock, ProductStatus productStatus) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.productStatus = productStatus;
    }

    public static Products toEntity(ProductDto productDto, ProductStatus status) {
        return Products.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(new BigDecimal(productDto.getPrice()))
                .category(productDto.getCategory())
                .stock(new BigDecimal(productDto.getStock()))
                .productStatus(status)
                .build();
    }
}
