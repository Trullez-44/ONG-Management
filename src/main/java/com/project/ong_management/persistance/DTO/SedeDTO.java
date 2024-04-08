package com.project.ong_management.persistance.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;


@Data
public class SedeDTO {

    private int sedeId;

    @NotBlank(message = "El nombre de la sede no puede estar en blanco")
    @Size(min = 1, max = 255, message = "El nombre de la sede debe tener entre 1 y 255 caracteres")
    private String nombre;

    @NotBlank(message = "La dirección de la sede no puede estar en blanco")
    @Size(min = 1, max = 255, message = "La dirección de la sede debe tener entre 1 y 255 caracteres")
    private String direccion;

    @NotBlank(message = "El nombre de la ciudad no puede estar en blanco")
    @Size(min = 1, max = 255, message = "El nombre de la ciudad debe tener entre 1 y 255 caracteres")
    private String ciudad;

    @NotBlank(message = "El nombre del director no puede estar en blanco")
    @Size(min = 1, max = 255, message = "El nombre del director debe tener entre 1 y 255 caracteres")
    private String director;

    private List<SocioDTO> socios; // Considera cambiar a SocioDTO si no necesitas todos los datos de Socio

}
