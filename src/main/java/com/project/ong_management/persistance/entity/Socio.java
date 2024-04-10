package com.project.ong_management.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Socio")
public class Socio extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socioId")
    private int socioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sede_id", referencedColumnName = "sedeId", nullable = false)
    private Sede sede;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    private List<ReporteCuota> reportes;
}
