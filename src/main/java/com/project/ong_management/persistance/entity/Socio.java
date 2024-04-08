package com.project.ong_management.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Socio")
public class Socio extends Persona{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sede_id", referencedColumnName = "sedeId") // nombre de la columna en la tabla Socio que hace referencia a la tabla Sede
    private Sede sede;
}