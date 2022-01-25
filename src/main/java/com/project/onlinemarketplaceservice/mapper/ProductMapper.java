package com.project.onlinemarketplaceservice.mapper;

import com.project.onlinemarketplaceservice.dto.BaseProductDto;
import com.project.onlinemarketplaceservice.dto.InsertProductDto;
import com.project.onlinemarketplaceservice.dto.ProductDetailDto;
import com.project.onlinemarketplaceservice.dto.UpdateProductDto;
import com.project.onlinemarketplaceservice.pagination.ProductSearchConditionDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {

    void insertProduct(InsertProductDto productDto);

    List<BaseProductDto> selectProductList(ProductSearchConditionDto productSearchConditionDto);

    Integer selectProductTotalCount();

    ProductDetailDto selectProduct(int productId);

    void updateProduct(@Param("productId") int productId,
            @Param("UpdateProductDto") UpdateProductDto productDto);

    void deleteProduct(@Param("productId") int productId);
}
