package com.project.ong_management.persistance.entity;

import jakarta.validation.constraints.*;
import lombok.*;
import jakarta.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Persona {

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @NotBlank(message = "El apellido no puede estar en blanco")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;

    @NotBlank(message = "El teléfono no puede estar en blanco")
    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener 10 dígitos")
    @Column(name = "telefono", length = 10, nullable = false)
    private String telefono;

    @NotBlank(message = "El correo electrónico no puede estar en blanco")
    @Email(message = "El correo electrónico debe tener un formato válido")
    @Column(name = "correo_electronico", length = 100, nullable = false, unique = true)
    private String correoElectronico;

}
