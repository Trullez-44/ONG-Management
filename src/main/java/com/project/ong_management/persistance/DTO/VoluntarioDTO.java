package com.project.ong_management.persistance.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.ong_management.persistance.entity.Sede;
import lombok.Data;

@Data
public class VoluntarioDTO {

    private int voluntarioId;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String profesion;
    private boolean disponibilidad;
    private String tipoVoluntario;

    private Sede sede;
}
