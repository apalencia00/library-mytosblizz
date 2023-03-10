package com.library.mytoysblizz.domain.dto.orden;

import com.library.mytoysblizz.domain.dto.producto.Producto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class Orden {

    private Integer id_orden;
    private String num_orden;
    private Integer cliente_id;
    private LocalDate fecha_orden;
    private Boolean is_vigente;
    private List<Producto> lst_producto;
    private Boolean is_cancelada;
    private Boolean is_reembolso;
    private LocalDate fecha_devolucion;
    private static final  Integer dias_tras_cancelacion = 30;

    private void diasCancelacion(LocalDate fecha_orden){
        this.fecha_orden = fecha_orden;
        this.is_cancelada = true;
        this.is_reembolso = false;
    }

}
