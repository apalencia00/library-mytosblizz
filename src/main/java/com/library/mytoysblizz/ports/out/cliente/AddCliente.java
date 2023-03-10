package com.library.mytoysblizz.ports.out.cliente;

import com.library.mytoysblizz.application.persistence.cliente.ClienteEntity;
import com.library.mytoysblizz.domain.dto.cliente.Cliente;

public interface AddCliente {

    ClienteEntity create(Cliente clienteDto);
}
