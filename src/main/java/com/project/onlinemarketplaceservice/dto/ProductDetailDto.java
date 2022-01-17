package com.project.onlinemarketplaceservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {

    private Long productId;
    private BaseProductDto baseProductDto;
    private String description;
    private String detailedImage1;
    private String detailedImage2;
    private String detailedImage3;
    private LocalDateTime publishedAt;

}
