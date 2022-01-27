package com.project.onlinemarketplaceservice.mapper;

import com.project.onlinemarketplaceservice.dto.InsertProductDto;
import com.project.onlinemarketplaceservice.dto.Product;
import com.project.onlinemarketplaceservice.dto.ProductDetailDto;
import com.project.onlinemarketplaceservice.dto.ProductSearch;
import com.project.onlinemarketplaceservice.dto.UpdateProductDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

@Mapper
public interface ProductMapper {

    void insertProduct(InsertProductDto productDto);

    List<Product> selectProductList(@Param("search") ProductSearch productSearch,
            @Param("pageable") Pageable pageable);

    Long selectProductTotalCount(@Param("search") ProductSearch productSearch);

    ProductDetailDto selectProduct(int productId);

    void updateProduct(@Param("productId") int productId,
            @Param("UpdateProductDto") UpdateProductDto productDto);

    void deleteProduct(@Param("productId") int productId);


}
