package com.project.ong_management.persistance.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.ong_management.persistance.entity.Sede;
import com.project.ong_management.persistance.entity.TipoVoluntario;
import lombok.Data;

@Data
public class VoluntarioDTO {

    private int voluntarioId;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correoElectronico;
    private String profesion;
    private boolean disponibilidad;
    private TipoVoluntario tipoVoluntario;
    private Integer sedeId;
    private SedeDTO sede;
}
