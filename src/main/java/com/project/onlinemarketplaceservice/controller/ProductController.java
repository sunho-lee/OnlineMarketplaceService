package com.project.onlinemarketplaceservice.controller;

import com.project.onlinemarketplaceservice.constants.CacheNameConstants;
import com.project.onlinemarketplaceservice.dto.InsertProductDto;
import com.project.onlinemarketplaceservice.dto.Product;
import com.project.onlinemarketplaceservice.dto.ProductDetailDto;
import com.project.onlinemarketplaceservice.dto.ProductSearch;
import com.project.onlinemarketplaceservice.dto.UpdateProductDto;
import com.project.onlinemarketplaceservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public void addProductInStore(@RequestBody InsertProductDto productDto) {
        productService.addProductInStore(productDto);
    }

    @GetMapping
    public Page<Product> getProductList(
            @RequestParam(value = "cateId", required = false) Integer categoryId,
            @RequestParam(value = "keyword", required = false) String searchKeyword,
            @RequestParam(value = "sellerId", required = false) Long sellerId,
            @PageableDefault(page = 1, size = 40, sort = "publishedAt",
                    direction = Sort.Direction.DESC) Pageable pageable) {
        return productService
                .getProductList(new ProductSearch(categoryId, searchKeyword, sellerId), pageable);
    }

    @GetMapping("/{productId}")
    public ProductDetailDto getProduct(@PathVariable("productId") int productId) {
        return productService.getProduct(productId);
    }

    @PutMapping("/{productId}")
    public void modifyProduct(@PathVariable int productId,
            @RequestBody UpdateProductDto productDto) {
        productService.modifyProduct(productId, productDto);
    }

    @CacheEvict(value = CacheNameConstants.PRODUCT, key = "#productId")
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
    }
}