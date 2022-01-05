package com.project.onlinemarketplaceservice.mapper;

import com.project.onlinemarketplaceservice.dto.ProductDto;
import com.project.onlinemarketplaceservice.dto.ProductListDto;
import com.project.onlinemarketplaceservice.dto.SearchConditionDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {

  void insertProduct(ProductDto productDto);

  List<ProductListDto> selectProductList(SearchConditionDto searchConditionDto);

  ProductDto selectProduct(int productId);

  int selectProductListCount(SearchConditionDto searchConditionDto);

  int updateProduct(@Param("productId") int productId, @Param("ProductDto") ProductDto productDto);

  void deleteProduct(@Param("storeId") int storeId, @Param("productId") int productId);
}
