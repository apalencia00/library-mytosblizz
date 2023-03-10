package com.library.mytoysblizz.domain.dto.producto;

import lombok.*;

import java.time.LocalDate;
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Producto {

    private Integer id;
    private String nombre_producto;
    private String codigo_producto;
    private Double valor_producto;
    private String descripcion;
    private Integer inStock;
    private Integer cantidad;
    private Boolean vence;
    private LocalDate fecha_vencimiento;
    private LocalDate fecha_registro;
    private String ubicacion;

}
