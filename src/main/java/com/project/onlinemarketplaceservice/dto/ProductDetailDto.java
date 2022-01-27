package com.project.onlinemarketplaceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {

    private Product product;
    private String description;
    private String detailedImage1;
    private String detailedImage2;
    private String detailedImage3;

}
