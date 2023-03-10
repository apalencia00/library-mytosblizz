package com.library.mytoysblizz.ports.in.persona;

import com.library.mytoysblizz.application.persistence.persona.PersonaEntity;
import com.library.mytoysblizz.domain.dto.Persona;

public interface CreatePersona {

   PersonaEntity create(Persona persona);
}
