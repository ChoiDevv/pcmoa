package com.example.pcmoa.product.entity.dto;

import com.example.pcmoa.product.entity.ProductImages;
import com.example.pcmoa.product.entity.ProductStatus;
import com.example.pcmoa.product.entity.Products;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProductsDto {

    private Long id;
    private String name;
    private String createdDate;
    private String description;
    private Long price;
    private String category;
    private Long stock;
    private Long hits;
    private ProductImages productImages;

    @Builder
    public ProductsDto(Long id, String name, String createdDate, String description, Long price, String category, Long stock, Long hits, ProductImages productImages) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.hits = hits;
        this.productImages = productImages;
    }

    public static List<ProductsDto> transformation(List<Products> products) {
        List<ProductsDto> data = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Products product: products) {
            ProductsDto dto = ProductsDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .createdDate(product.getCreatedDate().format(formatter))
                    .description(product.getDescription())
                    .price(product.getPrice().longValue())
                    .category(product.getCategory())
                    .stock(product.getStock().longValue())
                    .hits(product.getHits())
                    .productImages(product.getImages().get(0))
                    .build();
            data.add(dto);
        }
        return data;
    }
}
