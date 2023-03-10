package com.library.mytoysblizz.application.persistence.persona;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "persona")
@Data
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_persona;
    @Column
    private Integer tipo_documento;
    @Column
    private String documento;
    @Column
    private String nombre;
    @Column
    private String segundo_nombre;
    @Column
    private String apellido;
    @Column
    private String segundo_apellido;
    @Column
    private LocalDate fecha_nacimiento;
    @Column
    private char genero;
    @Column
    Boolean activo;
    @Column
    @CreatedDate
    LocalDate fecha_registro;

}
