package com.project.ong_management.persistance.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Sede")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sedeId")
    @JsonIgnoreProperties(value = {"socios"})
    private int sedeId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;

    @Column(name = "director", nullable = false)
    private String director;

    @OneToMany(mappedBy = "sede", cascade = CascadeType.ALL)
    private List<Socio> socios;

    @ManyToMany()
    @JoinTable(
            name="sedes_colaboradoras",
            joinColumns=@JoinColumn(name="sedeId"),
            inverseJoinColumns=@JoinColumn(name="envioId")
    )
    private Set<Envio> envios;
}
