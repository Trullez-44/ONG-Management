package com.project.ong_management.persistance.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refugioId", referencedColumnName = "refugioId", nullable = false)
    private Refugio refugio;

    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonManagedReference
    private List<EnvioDetalles> envioDetalles;

    @ManyToMany()
    @JoinTable(
            name = "sedes_colaboradoras",
            joinColumns = {@JoinColumn(name = "envioId")},
            inverseJoinColumns = {@JoinColumn(name = "sedeId")})
    private Set<Sede> sedes;
}
