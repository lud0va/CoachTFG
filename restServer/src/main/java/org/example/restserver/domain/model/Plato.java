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
@Table(name ="plato")
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplato", nullable = false)
    private int id;

    @Column(name = "desc")
    private String desc;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "hora")
    private String hora;
    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "iddietas" ,insertable=false, updatable=false)
    private Dieta dietasConPlato;

    @OneToMany(mappedBy = "alimento", cascade = {CascadeType.REMOVE})
    private List<PlatoAlimentosElem> plato;
}
