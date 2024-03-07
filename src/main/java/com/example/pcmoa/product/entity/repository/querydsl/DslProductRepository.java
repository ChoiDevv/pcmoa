package com.example.pcmoa.product.entity.repository.querydsl;

import com.example.pcmoa.product.entity.ProductStatus;
import com.example.pcmoa.product.entity.Products;
import com.example.pcmoa.product.entity.QProductImages;
import com.example.pcmoa.product.entity.dto.ProductsDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

import static com.example.pcmoa.product.entity.QProductImages.productImages;
import static com.example.pcmoa.product.entity.QProducts.products;

@Repository
@RequiredArgsConstructor
public class DslProductRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public List<Products> findAllProductsWithImages() {
        return jpaQueryFactory
                .selectFrom(products)
                .innerJoin(productImages).on(products.id.eq(productImages.products.id))
                .where(products.productStatus.eq(ProductStatus.SELL)
                        .and(products.stock.ne(BigDecimal.ZERO)))
                .fetchJoin()
                .fetch();
    }
}
