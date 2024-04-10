package com.project.ong_management.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Voluntario")
public class Voluntario extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voluntarioId")
    private int voluntarioId;

    @Column(name = "profesion")
    private String profesion;

    @Column(name = "disponibilidad")
    private boolean disponibilidad;

    @Column(name = "tipoVoluntario", nullable = false)
    private TipoVoluntario tipoVoluntario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sedeId", referencedColumnName = "sedeId")
    private Sede sede;

    @ManyToMany(mappedBy = "voluntarios", cascade = CascadeType.ALL)
    private Set<EnvioDetalles> envioDetallesSet;
}
