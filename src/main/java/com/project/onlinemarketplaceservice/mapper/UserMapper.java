package com.project.onlinemarketplaceservice.mapper;

import com.project.onlinemarketplaceservice.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;


/*
 * @Mapper : Mybatis 매핑XML에 기재된 SQL을 호출하기 위한 인터페이스입니다.(MyBatis3.0부터 지원)
 */
@Mapper
public interface UserMapper {

    void insertUser(UserDto user);

    boolean isUsingId(String id);

    UserDto findUserByIdAndPassword(UserDto user);

    UserDto findUserById(String userId);

    void updateUser(UserDto user);

    void deleteUser(UserDto user);
}
