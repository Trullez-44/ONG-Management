package com.project.ong_management.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EnvioDetalles")
public class EnvioDetalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "envioDetallesId")
    private int envioDetallesId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "envioId", referencedColumnName = "envioId", nullable = false)
    private Envio envio;

    @Column(name = "tipoCarga", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoCarga tipoCarga;

    @Column(name = "nombreProducto", nullable = false)
    private String nombreProducto;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "numUnidades", nullable = false)
    private int numUnidades;

    @Column(name = "numToneladas", nullable = false)
    private int numToneladas;
}