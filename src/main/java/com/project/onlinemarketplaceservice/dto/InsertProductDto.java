package com.project.onlinemarketplaceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertProductDto {

    private BaseProductDto baseProductDto;
    private String detailedImage1;
    private String detailedImage2;
    private String detailedImage3;

}
