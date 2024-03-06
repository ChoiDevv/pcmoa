package com.example.pcmoa.product.entity.repository;

import com.example.pcmoa.product.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
}
