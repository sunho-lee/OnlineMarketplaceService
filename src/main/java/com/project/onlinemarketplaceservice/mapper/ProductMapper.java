package com.project.onlinemarketplaceservice.mapper;

import com.project.onlinemarketplaceservice.dto.BaseProductDto;
import com.project.onlinemarketplaceservice.dto.InsertProductDto;
import com.project.onlinemarketplaceservice.dto.ProductListDto;
import com.project.onlinemarketplaceservice.dto.SearchConditionDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {

    void insertProduct(InsertProductDto productDto);

    List<ProductListDto> selectProductList(SearchConditionDto searchConditionDto);

    BaseProductDto selectProduct(int productId);

    int selectProductListCount(SearchConditionDto searchConditionDto);

    int updateProduct(@Param("productId") int productId,
            @Param("ProductDto") BaseProductDto productDto);

    void deleteProduct(@Param("storeId") int storeId, @Param("productId") int productId);
}
