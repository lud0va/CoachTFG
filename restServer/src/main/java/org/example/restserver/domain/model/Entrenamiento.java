package org.example.restserver.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="entrenamiento")
public class  Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identrenamiento", nullable = false)
    private int id;
    @Column(name = "dia_semana", nullable = false)
    private String diaSemana;
    @Column(name = "tipo", nullable = false)
    private String tipo;


    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "idcoachee", nullable = false)
    private Coachee coachee;
    @OneToMany(mappedBy = "entrem", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Ejercicios> ejercicios;
}
