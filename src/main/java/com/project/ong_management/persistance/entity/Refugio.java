package com.project.ong_management.persistance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Refugio")
public class Refugio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "refugioId")
    private int refugioId;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "direccion", nullable = false)
    private String direccion;

}
