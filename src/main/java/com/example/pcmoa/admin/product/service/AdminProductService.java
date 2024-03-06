package com.example.pcmoa.admin.product.service;

import com.example.pcmoa.admin.product.dto.AdminProductDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AdminProductService {
    void save(String name, String description, long price, String category, long stock, List<MultipartFile> images) throws IOException;
}
