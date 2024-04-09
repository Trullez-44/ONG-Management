package com.project.ong_management.persistance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Envio")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "envioId")
    private int envioId;

    @Column(name = "codigoEnvio", nullable = false)
    private String codigoEnvio;

    @Column(name = "fechaSalida", nullable = false)
    private Date fechaSalida;

    @Column(name = "destino", nullable = false)
    private String destino;

    @Column(name = "tipoEnvio", nullable = false)
    private String tipoEnvio;

    @Column(name = "sedeId", nullable = false)
    private int sedeId;

}
