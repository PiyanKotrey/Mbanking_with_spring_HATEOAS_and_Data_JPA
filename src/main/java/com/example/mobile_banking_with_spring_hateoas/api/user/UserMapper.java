package com.example.mobile_banking_with_spring_hateoas.api.user;

import com.example.mobile_banking_with_spring_hateoas.api.user.web.CreateUserDto;
import com.example.mobile_banking_with_spring_hateoas.api.user.web.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapCreateUserDtoToUser(CreateUserDto createUserDto);
    UserDto mapUserToUserDto(User user);
    List<UserDto> mapListUserToListUserDto(List<User> users);
}
