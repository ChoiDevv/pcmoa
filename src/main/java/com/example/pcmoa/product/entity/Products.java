package com.example.pcmoa.product.entity;

import com.example.pcmoa.config.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImages> images;

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

    public static Products toEntity(String name, String description, long price, String category, long stock, ProductStatus status) {
        return Products.builder()
                .name(name)
                .description(description)
                .price(new BigDecimal(price))
                .category(category)
                .stock(new BigDecimal(stock))
                .productStatus(status)
                .hits(0L)
                .build();
    }
}
