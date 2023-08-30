package com.example.mobile_banking_with_spring_hateoas.api.user;

import com.example.mobile_banking_with_spring_hateoas.api.user.web.UserController;
import com.example.mobile_banking_with_spring_hateoas.api.user.web.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, EntityModel<UserDto>> {
    private UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @SuppressWarnings("unchecked")
    public UserModelAssembler(){
        super(UserController.class,(Class<EntityModel<UserDto>>) (Class<?> )EntityModel.class);
    }

    @Override
    public EntityModel<UserDto> toModel(User entity) {
        UserDto userDto = userMapper.mapUserToUserDto(entity);
        Link collectionLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class)
                .findAllUser()).withRel(IanaLinkRelations.COLLECTION);
        Link setfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class)
                .findByUuid(entity.getUuid())).withSelfRel();
        return EntityModel.of(userDto,setfLink,collectionLink);
    }

    @Override
    public CollectionModel<EntityModel<UserDto>> toCollectionModel(Iterable<? extends User> entities) {
        return super.toCollectionModel(entities);
    }
}
