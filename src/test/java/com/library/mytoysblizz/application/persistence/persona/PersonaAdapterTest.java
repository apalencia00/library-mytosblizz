package com.library.mytoysblizz.application.persistence.persona;

import com.library.mytoysblizz.domain.dto.Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;

class PersonaAdapterTest {


  private PersonaRepository personaRepository = Mockito.mock(PersonaRepository.class);
  private PersonaAdapter underPersonaAdapter = new PersonaAdapter(personaRepository);



  @BeforeEach
  void setup() {

    Persona p = Persona.builder()
        .id(1)
        .documento("1140824197")
        .tipo_documento(1)
        .nombre("Andres")
        .apellido("Palencia")
        .activo(Boolean.TRUE)
        .fecha_nacimiento(LocalDate.now())
        .genero('M')
        .segundo_nombre("Felipe")
        .segundo_apellido("Florez")

        .build();

    PersonaEntity per = PersonaMapper.INSTANCE.toEntity(p);
    personaRepository.save(per);

  }

  @Test
  void findById() {
    this.personaRepository.findById(1);
    then(this.personaRepository).should().findById(1);
  }

  @Test
  void findAll() {
    this.personaRepository.findAll();
    then(this.personaRepository).should().findAll();
  }

  @Test
  void create() {

    Persona p = Persona.builder()
        .id(1)
        .documento("1140824197")
        .tipo_documento(1)
        .nombre("Andres")
        .apellido("Palencia")
        .activo(Boolean.TRUE)
        .fecha_nacimiento(LocalDate.now())
        .genero('M')
        .segundo_nombre("Felipe")
        .segundo_apellido("Florez")

        .build();

    PersonaEntity per = underPersonaAdapter.create(p);

    assertTrue(per != null);
    assertEquals(per.getNombre(), p.getNombre());

  }

}