package com.project.ong_management.persistance.DTO;

import com.project.ong_management.persistance.entity.Refugio;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class EnvioDTO {

//    private Integer envioId;
    private String codigoEnvio;
    private Date fechaSalida;
    private Integer refugioId;
//    private Refugio refugio;
    private List<Integer> sedes;
    private List<EnvioDetallesDTO> detalles;


}
