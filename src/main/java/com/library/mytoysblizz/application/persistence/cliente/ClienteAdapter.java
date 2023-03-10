package com.library.mytoysblizz.application.persistence.cliente;

import com.library.mytoysblizz.domain.dto.cliente.Cliente;
import com.library.mytoysblizz.ports.in.cliente.ListCliente;
import com.library.mytoysblizz.ports.out.cliente.AddCliente;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClienteAdapter implements ListCliente, AddCliente {


   private final ClienteRepository clienteRepository;

    @Override
    public Optional<ClienteEntity> findById(Integer id) throws Exception {
       return Optional.of(this.clienteRepository.findById(id)).orElseThrow(() -> new Exception("El cliente no existe con id :" + id) );
    }

    @Override
    public Iterable<ClienteEntity> findAll() {

       return this.clienteRepository.findAll();
    }

    @Override
    public ClienteEntity create(Cliente clienteDto) {
       ClienteEntity clienteEntity = ClienteMapper.INSTANCE.toEntity(clienteDto);
       if ( clienteDto != null ){
           this.clienteRepository.save(clienteEntity);
           return clienteEntity;
       }
        return null;
    }
}
