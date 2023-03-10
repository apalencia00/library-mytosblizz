package com.library.mytoysblizz.domain.dto;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Persona implements Serializable {


  private Integer id;
  private Integer tipo_documento;
  private String documento;
  private String nombre;
  private String segundo_nombre;
  private String apellido;
  private String segundo_apellido;
  private LocalDate fecha_nacimiento;
  private char genero;
  private Boolean activo;

}
