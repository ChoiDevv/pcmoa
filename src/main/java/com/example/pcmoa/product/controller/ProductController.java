package com.example.pcmoa.product.controller;

import com.example.pcmoa.product.entity.dto.ProductsDto;
import com.example.pcmoa.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * 메인 페이지 렌더링
     * @author ChoiDevv
     * @return String | "/product/main" 메인 페이지
     */
    @GetMapping("/")
    public String index(Model model) {
        List<ProductsDto> products = productService.index();
        model.addAttribute("products", products);
        return "product/main";
    }
}
