package com.project.onlinemarketplaceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseProductDto {

    private Long sellerId;
    private String title;
    private Integer price;
    private Integer shippingFee;
    private String categoryId;
    private Integer amount;
    private String mainImage;

}