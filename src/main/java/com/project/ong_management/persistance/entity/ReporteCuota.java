package com.project.ong_management.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ReporteCuota")
public class ReporteCuota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reporteId")
    private int reporteId;

    @Column(name = "fechaPago", nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "cuentaBancaria", nullable = false, length = 255)
    private String cuentaBancaria;

    @Column(name = "tipoCuota", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCuota tipoCuota;

    @Column(name = "importeTotal", nullable = false)
    private Double importeTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "socioId")
    @JsonIgnore
    private Socio socio;
}
