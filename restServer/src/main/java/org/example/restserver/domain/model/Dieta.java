package org.example.restserver.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="dieta")
public class Dieta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddieta", nullable = false)
    private int id;

    @Column(name = "fija")
    private String fija;

    @Column(name = "caloriasmaxdia")
    private int caloriasmaxdia;

    @Column(name = "fin_dieta")
    private LocalDate finDieta;
    @Column(name = "idcoachee")
    private int idcoachee;

    @OneToMany(mappedBy = "dietasConPlato", cascade = {CascadeType.REMOVE})
    private List<Plato> platoDeDieta;

    @OneToMany(mappedBy = "alimento", cascade = {CascadeType.REMOVE})
    private List<AlimentosPermitidos> alimentosPermitidos;
}
