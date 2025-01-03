package cz.krabec.exampleapp.model.mapper;

import cz.krabec.exampleapp.entity.UserEntity;
import cz.krabec.exampleapp.model.User;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
@SuppressWarnings("unused")
public interface UserMapper extends AbstractMapper<User, UserEntity>{

}