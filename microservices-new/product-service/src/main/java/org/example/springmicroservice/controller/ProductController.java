package org.example.springmicroservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.springmicroservice.model.dto.ProductRequestDto;
import org.example.springmicroservice.model.dto.ProductResponseDto;
import org.example.springmicroservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequestDto request) {
        productService.createProduct(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
