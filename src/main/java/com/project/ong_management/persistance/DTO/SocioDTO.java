package com.project.ong_management.persistance.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.ong_management.persistance.entity.ReporteCuenta;
import com.project.ong_management.persistance.entity.Sede;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;


@Data
public class SocioDTO {

    private int socioId;

    @NotBlank(message = "el nombre del socio no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "el apellido del socio no puede estar en blanco")
    private String apellido;

    @NotBlank(message = "el teléfono del socio no puede estar en blanco")
    @Pattern(regexp = "\\d{10}", message = "el teléfono del socio debe contener 10 dígitos")
    private String telefono;

    @NotBlank(message = "el correo electrónico del socio no puede estar en blanco")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "el correo electrónico del socio no es válido")
    private String correoElectronico;

    private SedeDTO sede;

    private List<ReporteCuenta> reportes;

}
