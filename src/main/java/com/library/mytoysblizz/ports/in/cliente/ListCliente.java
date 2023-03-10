package com.library.mytoysblizz.ports.in.cliente;

import com.library.mytoysblizz.application.persistence.cliente.ClienteEntity;

import java.util.Optional;

public interface ListCliente {

   Optional<ClienteEntity> findById(Integer id) throws Exception;
   Iterable<ClienteEntity> findAll();
}
