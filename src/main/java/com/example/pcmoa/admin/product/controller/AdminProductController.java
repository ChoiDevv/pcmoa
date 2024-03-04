package com.example.pcmoa.admin.product.controller;

import com.example.pcmoa.admin.product.service.AdminProductService;
import com.example.pcmoa.product.entity.dto.ProductDto;
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
    public ResponseEntity<String> save(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body("유효성 검사가 실패했습니다.");
            }
            adminProductService.save(productDto);
            return ResponseEntity.ok("저장완료");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("에러: " + e.getMessage());
        }
    }
}