package com.project.ong_management.persistance.DTO;

import com.project.ong_management.persistance.entity.TipoCarga;
import com.project.ong_management.persistance.entity.Voluntario;
import lombok.Data;

import java.util.List;

@Data
public class EnvioDetallesDTO {

//    private Integer envioDetallesId;
    private Integer envioId;
    private String nombreProducto;
    private String descripcion;
    private Integer numUnidades;
    private Integer numToneladas;
    private List<Integer> voluntariosIds;
//    private List<Voluntario> voluntarios;
}
