package com.example.pcmoa.product.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class ProductDto {

    @NotBlank(message = "상품명은 필수값입니다.")
    private String name;

    @NotBlank(message = "상품 소개는 필수값입니다.")
    private String description;

    @NotNull(message = "가격 설정을 해주세요.")
    private Long price;

    @NotBlank(message = "카테고리를 설정해주세요.")
    private String category;

    @NotNull(message = "재고수를 설정해주세요.")
    private Long stock;

    @Builder
    public ProductDto(String name, String description, Long price, String category, Long stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;
    }
}
