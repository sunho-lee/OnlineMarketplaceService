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
public class InsertProductDto {

    private Long sellerId;
    private String title;
    private Integer price;
    private Integer shippingFee;
    private Integer categoryId;
    private Integer amount;
    private String description;
    private String mainImage;
    private String detailedImage1;
    private String detailedImage2;
    private String detailedImage3;

}
