package org.example.springmicroservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springmicroservice.model.dto.ProductRequestDto;
import org.example.springmicroservice.model.dto.ProductResponseDto;
import org.example.springmicroservice.model.entity.Product;
import org.example.springmicroservice.repository.ProductDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDao productDao;

    public void createProduct(ProductRequestDto requestDto) {
        Product product = Product.builder()
                .name(requestDto.getName())
                .description(requestDto.getDescription())
                .price(requestDto.getPrice())
                .build();

        productDao.save(product);
        log.info("Product created: {}", product.getId());

    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productDao.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponseDto mapToProductResponse(Product product) {
        return ProductResponseDto.builder()
                .id(Long.valueOf(product.getId()))
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
