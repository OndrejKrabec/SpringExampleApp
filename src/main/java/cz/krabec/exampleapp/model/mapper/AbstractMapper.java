package cz.krabec.exampleapp.model.mapper;

import jakarta.validation.Valid;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@MapperConfig
@Named("MapperAbstract")
public interface AbstractMapper<M, E> {


    @Mappings(@Mapping(target = "id", ignore = true))
    E toEntity(M source);

    M toDTO(E source);

    void toEntity(@Valid M model, @MappingTarget E entity);
}

