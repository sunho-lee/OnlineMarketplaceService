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
public class UpdateProductDto {

    private BaseProductDto baseProductDto;
    private String description;
    private String detailedImage1;
    private String detailedImage2;
    private String detailedImage3;

}
