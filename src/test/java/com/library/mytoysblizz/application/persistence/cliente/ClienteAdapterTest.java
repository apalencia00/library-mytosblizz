package com.library.mytoysblizz.application.persistence.cliente;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.then;

import com.library.mytoysblizz.domain.dto.cliente.Cliente;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class ClienteAdapterTest {

  ClienteRepository clienteRepository = Mockito.mock(ClienteRepository.class);

  ClienteAdapter underClienteAdapter = new ClienteAdapter(clienteRepository);



  @Test
  void findById() {
    this.clienteRepository.findById(1);
    then(this.clienteRepository).should().findById(1);
  }

  @Test
  void findAll() {
    this.clienteRepository.findAll();
    then(this.clienteRepository).should().findAll();
  }

  @Test
  void create() {
    Cliente cliente = Cliente.builder()
        .idCliente(10)
        .clave_cliente("Asd.123")
        .usuario_cliente("apalencia")

        .build();

    ClienteEntity clienteEntity = underClienteAdapter.create(cliente);

    assertTrue(clienteEntity != null);
    assertEquals(cliente.getClave_cliente(), clienteEntity.getClave_cliente());

  }
}