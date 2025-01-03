package cz.krabec.exampleapp.model.mapper;

import cz.krabec.exampleapp.entity.UserEntity;
import cz.krabec.exampleapp.model.UserUpdated;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
@SuppressWarnings("unused")
public interface UserUpdatedMapper extends AbstractMapper<UserUpdated, UserEntity> {

}