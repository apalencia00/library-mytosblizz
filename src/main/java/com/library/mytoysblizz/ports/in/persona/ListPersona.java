package com.library.mytoysblizz.ports.in.persona;

import com.library.mytoysblizz.application.persistence.persona.PersonaEntity;

import java.util.Optional;

public interface ListPersona {

    Optional<PersonaEntity> findById(Integer id) throws Exception;
    Iterable<PersonaEntity> findAll();
}
