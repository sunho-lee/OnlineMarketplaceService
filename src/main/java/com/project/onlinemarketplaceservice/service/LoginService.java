package com.project.onlinemarketplaceservice.service;

import com.project.onlinemarketplaceservice.dto.UserDto;

public interface LoginService {

    void login(UserDto user);

    void logout();

    String getLoginId();

    UserDto getLoginUserInfo();
}
