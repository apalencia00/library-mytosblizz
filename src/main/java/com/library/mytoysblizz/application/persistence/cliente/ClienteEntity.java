package com.library.mytoysblizz.application.persistence.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String usuario_cliente;
    @Column
    private String clave_cliente;
    @Column
    private LocalDate fecha_ultimo_acceso;
    @Column
    private Boolean activo;
    @Column
    private LocalDate fecha_registro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Integer id_persona;
}
