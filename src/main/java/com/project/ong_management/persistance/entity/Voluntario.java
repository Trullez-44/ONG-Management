package com.project.ong_management.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Voluntario")
public class Voluntario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voluntarioId")
    private int voluntarioId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "profesion")
    private String profesion;

    @Column(name = "disponibilidad")
    private boolean disponibilidad;

    @Column(name = "tipoVoluntario", nullable = false)
    private String tipoVoluntario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sedeId", referencedColumnName = "sedeId")
    private Sede sede;
}
