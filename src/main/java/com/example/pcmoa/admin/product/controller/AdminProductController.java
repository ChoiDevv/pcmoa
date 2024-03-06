package com.example.pcmoa.admin.product.controller;

import com.example.pcmoa.admin.product.service.AdminProductService;
import com.example.pcmoa.admin.product.dto.AdminProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminProductController {

    private final AdminProductService adminProductService;

    /**
     * 관리자 대시보드 상품 페이지 렌더링
     * @author ChoiDevv
     * @return String | "/admin/product_list" 상품 페이지 렌더링
     */
    @GetMapping("/admin/product-list")
    public String products(Model model) {
        return "admin/product_list";
    }

    /**
     * 관리자 대시보드 상품 저장 AJAX
     * @author ChoiDevv
     * @param @RequestBody ProductDto 비동기 통신으로 받은 JSON Object
     * @return String | "저장완료" (추후에 Object로 변경 예정)
     */
    @PostMapping("/admin/product/save")
    public ResponseEntity<String> save(@RequestParam("name") String name, @RequestParam("description") String description,
                                       @RequestParam("price") long price, @RequestParam("category") String category,
                                       @RequestParam("stock") long stock, @RequestParam("images")List<MultipartFile> images) {
        try {
            adminProductService.save(name, description, price, category, stock, images);
            return ResponseEntity.ok("저장완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("에러: " + e.getMessage());
        }
    }
}
