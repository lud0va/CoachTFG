package org.example.restserver.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ejercicios")
public class Ejercicios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idejercicios", nullable = false)
    private int id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "dificultad", nullable = false)
    private String dificultad;
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "identrenamiento" ,insertable=false, updatable=false)
    private Entrenamiento entrem;
    @Column(name = "identrenamiento")
    private int identrenamiento;

}
