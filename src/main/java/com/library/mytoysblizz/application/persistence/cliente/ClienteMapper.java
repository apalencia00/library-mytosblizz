package com.library.mytoysblizz.application.persistence.cliente;

import com.library.mytoysblizz.domain.dto.cliente.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
 )
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);


    ClienteEntity toEntity(Cliente cliente);

    Cliente toDto(ClienteEntity clienteEntity);

}
