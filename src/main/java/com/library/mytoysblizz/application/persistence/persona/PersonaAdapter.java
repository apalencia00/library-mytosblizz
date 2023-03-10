package com.library.mytoysblizz.application.persistence.persona;

import com.library.mytoysblizz.domain.dto.Persona;
import com.library.mytoysblizz.ports.in.persona.ListPersona;
import com.library.mytoysblizz.ports.out.persona.AddPersona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
@RequiredArgsConstructor

public class PersonaAdapter implements ListPersona, AddPersona {


  private final PersonaRepository personaRepository;

  @Override
  public Optional<PersonaEntity> findById(Integer id) throws Exception {
    return Optional.of(this.personaRepository.findById(id))
        .orElseThrow(() -> new Exception("Persona-Cliente no encontrado con id :" + id));
  }

  @Override
  public Iterable<PersonaEntity> findAll() {
    return this.personaRepository.findAll();
  }

  @Override
  public PersonaEntity create(Persona personaDto) {

    PersonaEntity p = PersonaMapper.INSTANCE.toEntity(personaDto);
    if (p.getDocumento() != null) {
      this.personaRepository.save(p);
      return p;
    }
    return null;
  }
}
