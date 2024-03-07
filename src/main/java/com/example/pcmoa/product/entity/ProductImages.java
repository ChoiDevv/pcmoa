package com.example.pcmoa.product.entity;

import com.example.pcmoa.config.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "pcmoa_product_images")
public class ProductImages extends BaseEntity {

    private String image;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;

    @Builder
    public ProductImages(String image, Products products) {
        this.image = image;
        this.products = products;
    }

    public static ProductImages toEntity(String fileName, Products products) {
        return ProductImages.builder()
                .image(fileName)
                .products(products)
                .build();
    }
}
