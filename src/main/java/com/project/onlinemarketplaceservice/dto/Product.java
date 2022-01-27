package com.project.onlinemarketplaceservice.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long productId;
    private Long sellerId;
    private String nickname;
    private String title;
    private Integer price;
    private Integer shippingFee;
    private Integer categoryId;
    private String categoryName;
    private Integer amount;
    private String mainImage;
    private LocalDateTime publishedAt;

}