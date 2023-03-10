package com.library.mytoysblizz.domain.dto.cliente;

import com.library.mytoysblizz.domain.dto.Persona;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.asm.Advice.Local;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SuperBuilder

public class Cliente extends Persona implements Serializable {


    private Integer idCliente;
    private String usuario_cliente;
    private String clave_cliente;
    private LocalDate fecha_ultimo_acceso;
    private Boolean activo;
    private LocalDate fecha_registro;
    private Integer personaId;


    public Cliente(Integer id, Integer tipo_documento, String documento, String nombre,
        String segundo_nombre, String apellido, String segundo_apellido,
        LocalDate fecha_nacimiento, char genero, Boolean activo, Integer idCliente,
        String usuario_cliente, String clave_cliente, LocalDate fecha_ultimo_acceso,
        Boolean activo1, LocalDate fecha_registro, Integer personaId) {
        super(id, tipo_documento, documento, nombre, segundo_nombre, apellido, segundo_apellido,
            fecha_nacimiento, genero, activo);
        this.idCliente = idCliente;
        this.usuario_cliente = usuario_cliente;
        this.clave_cliente = clave_cliente;
        this.fecha_ultimo_acceso = fecha_ultimo_acceso;
        this.activo = activo1;
        this.fecha_registro = fecha_registro;
        this.personaId = personaId;
    }
}
