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

    @Column(name = "descripcion")
    private String desc;
    @Column(name = "hora")
    private String hora;
    @Column(name = "nombre")
    private String nombre;


    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "iddietas",insertable=false, updatable=false )
    private Dieta dietas;
    @Column(name = "iddietas")
    private int iddietas;




    @OneToMany(mappedBy = "alimentosPlato", cascade = {CascadeType.REMOVE})
    private List<PlatoAlimentosElem> alimentosPlato;

    public Plato(int id) {
        this.id = id;
    }
}
