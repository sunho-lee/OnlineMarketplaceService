package com.project.onlinemarketplaceservice.service;

import com.project.onlinemarketplaceservice.constants.CacheNameConstants;
import com.project.onlinemarketplaceservice.dto.BaseProductDto;
import com.project.onlinemarketplaceservice.dto.InsertProductDto;
import com.project.onlinemarketplaceservice.dto.ProductDetailDto;
import com.project.onlinemarketplaceservice.dto.UpdateProductDto;
import com.project.onlinemarketplaceservice.mapper.ProductMapper;
import com.project.onlinemarketplaceservice.pagination.PaginationProductListDto;
import com.project.onlinemarketplaceservice.pagination.ProductSearchConditionDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void addProductInStore(InsertProductDto productDto) {
        productMapper.insertProduct(productDto);
    }

    public PaginationProductListDto getProductList(
            ProductSearchConditionDto productSearchConditionDto) {
        List<BaseProductDto> productList = productMapper.selectProductList(
                productSearchConditionDto);
        Integer totalCount = productMapper.selectProductTotalCount();
        return new PaginationProductListDto(totalCount, productList,
                productSearchConditionDto.getRecordCountPerPage(),
                productSearchConditionDto.getCurrentPageNum());
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