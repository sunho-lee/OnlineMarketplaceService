package com.project.onlinemarketplaceservice.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {

    private BaseProductDto baseProductDto;
    private String description;
    private String detailedImage1;
    private String detailedImage2;
    private String detailedImage3;
    private LocalDateTime publishedAt;

}
