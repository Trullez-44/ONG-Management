package com.project.ong_management.persistance.DTO;

import lombok.Data;

@Data
public class SedeBasicaDTO {
    private int sedeId;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String director;
}
