package com.example.pcmoa.product.entity;

import com.example.pcmoa.config.entity.BaseEntity;
import com.example.pcmoa.admin.product.dto.AdminProductDto;
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
    public Products(String name, String description, BigDecimal price, String category, BigDecimal stock, ProductStatus productStatus, Long hits) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.productStatus = productStatus;
        this.hits = hits;
    }

    public static Products toEntity(AdminProductDto adminProductDto, ProductStatus status) {
        return Products.builder()
                .name(adminProductDto.getName())
                .description(adminProductDto.getDescription())
                .price(new BigDecimal(adminProductDto.getPrice()))
                .category(adminProductDto.getCategory())
                .stock(new BigDecimal(adminProductDto.getStock()))
                .productStatus(status)
                .hits(0L)
                .build();
    }
}
