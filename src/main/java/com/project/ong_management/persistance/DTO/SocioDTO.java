package com.project.ong_management.persistance.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class SocioDTO {

    private int socioId;

    @NotBlank(message = "El nombre del socio no puede estar en blanco")
    private String nombre;

    @NotBlank(message = "El apellido del socio no puede estar en blanco")
    private String apellido;

    @NotBlank(message = "El teléfono del socio no puede estar en blanco")
    @Pattern(regexp = "\\d{10}", message = "El teléfono del socio debe contener 10 dígitos")
    private String telefono;

    @NotBlank(message = "El correo electrónico del socio no puede estar en blanco")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "El correo electrónico del socio no es válido")
    private String correoElectronico;

}
