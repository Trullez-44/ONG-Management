package com.project.ong_management.persistance.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class EnvioDTO {

    private String codigoEnvio;
    private Date fechaSalida;
    private String destino;
    private String tipoEnvio;
    private int sedeId;

}
