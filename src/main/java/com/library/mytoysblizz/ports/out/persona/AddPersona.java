package com.library.mytoysblizz.ports.out.persona;

import com.library.mytoysblizz.application.persistence.persona.PersonaEntity;
import com.library.mytoysblizz.domain.dto.Persona;

public interface AddPersona {

    PersonaEntity create (Persona personaDto);
}
