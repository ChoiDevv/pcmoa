package com.example.pcmoa.product.entity.dto;

import com.example.pcmoa.product.entity.ProductStatus;
import com.example.pcmoa.product.entity.Products;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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
    private BigDecimal price;
    private String category;
    private BigDecimal stock;
    private Long hits;

    @Builder
    public ProductsDto(Long id, String name, String createdDate, String description, BigDecimal price, String category, BigDecimal stock, Long hits) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.hits = hits;
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
                    .price(product.getPrice())
                    .category(product.getCategory())
                    .stock(product.getStock())
                    .hits(product.getHits())
                    .build();
            data.add(dto);
        }
        return data;
    }
}
