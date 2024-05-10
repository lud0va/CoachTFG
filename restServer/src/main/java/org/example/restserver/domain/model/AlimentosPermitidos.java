package org.example.restserver.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.restserver.common.Constantes;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="alimentos_permitidos")
public class AlimentosPermitidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalimentosperm", nullable = false)
    private int id;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "iddietasp" ,insertable=false, updatable=false)
    private Dieta dietasConPlato;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "idalimentos" ,insertable=false, updatable=false)
    private Alimentos alimento;


    @Column(name = "cantidad", nullable = false)
    private String cantidad;
}

