package com.project.onlinemarketplaceservice.service;

import com.project.onlinemarketplaceservice.constants.CacheNameConstants;
import com.project.onlinemarketplaceservice.dto.InsertProductDto;
import com.project.onlinemarketplaceservice.dto.Product;
import com.project.onlinemarketplaceservice.dto.ProductDetailDto;
import com.project.onlinemarketplaceservice.dto.ProductSearch;
import com.project.onlinemarketplaceservice.dto.UpdateProductDto;
import com.project.onlinemarketplaceservice.mapper.ProductMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void addProductInStore(InsertProductDto productDto) {
        productMapper.insertProduct(productDto);
    }

    public Page<Product> getProductList(ProductSearch productSearch, Pageable pageable) {
        List<Product> productList = productMapper.selectProductList(productSearch, pageable);
        long totalCount = productMapper.selectProductTotalCount(productSearch);
        return new PageImpl<>(productList, pageable, totalCount);

    }

    @Cacheable(value = CacheNameConstants.PRODUCT, key = "#productId")
    public ProductDetailDto getProduct(int productId) {
        return productMapper.selectProduct(productId);
    }

    @CachePut(value = CacheNameConstants.PRODUCT, key = "#productId", unless = "#result == null")
    public void modifyProduct(int productId, UpdateProductDto productDto) {
        productMapper.updateProduct(productId, productDto);
    }

    public void deleteProduct(int productId) {
        productMapper.deleteProduct(productId);
    }
}