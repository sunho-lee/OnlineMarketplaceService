package com.project.onlinemarketplaceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearch {

    private Integer categoryId;
    private String keyword;
    private Long sellerId;

}