package com.project.onlinemarketplaceservice.service;

import com.project.onlinemarketplaceservice.constants.CacheNameConstants;
import com.project.onlinemarketplaceservice.dto.ProductDto;
import com.project.onlinemarketplaceservice.dto.ProductListDto;
import com.project.onlinemarketplaceservice.dto.SearchConditionDto;
import com.project.onlinemarketplaceservice.mapper.ProductMapper;
import com.project.onlinemarketplaceservice.paging.PaginationListDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void addProductInStore(ProductDto productDto) {
        productMapper.insertProduct(productDto);
    }

    public PaginationListDto getProductList(SearchConditionDto searchConditionDto) {
        List<ProductListDto> productListDto = productMapper.selectProductList(searchConditionDto);
        int totalRecordCount = getProductListCount(searchConditionDto);
        return new PaginationListDto(totalRecordCount, productListDto);
    }

    @Cacheable(value = CacheNameConstants.PRODUCT, key = "#productId")
    public ProductDto getProduct(int productId) {
        return productMapper.selectProduct(productId);
    }

    private int getProductListCount(SearchConditionDto searchConditionDto) {
        return productMapper.selectProductListCount(searchConditionDto);
    }

    @CachePut(value = CacheNameConstants.PRODUCT, key = "#productId")
    public void modifyProduct(int productId, ProductDto productDto) {
        productMapper.updateProduct(productId, productDto);
    }

    public void deleteProduct(int storeId, int productId) {
        productMapper.deleteProduct(storeId, productId);
    }
}