package com.project.onlinemarketplaceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;
    private String password;
    private String name;
    private String phone;
    private String type; // customer , seller
    private String address1;
    private String address2;
    private String regDt;
    private String modiDt;


}