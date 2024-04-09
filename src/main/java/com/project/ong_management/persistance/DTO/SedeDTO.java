package com.project.ong_management.persistance.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.ong_management.persistance.entity.Socio;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(value = {"socios"})
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

    private List<Socio> socios;

}
