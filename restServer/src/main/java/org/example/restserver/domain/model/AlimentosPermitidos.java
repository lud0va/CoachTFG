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
@Table(name ="alimentos_permitidos")
public class AlimentosPermitidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idalimentosperm", nullable = false)
    private int id;

    @JsonIgnore
    @ManyToOne( cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
    @JoinColumn(name = "iddietasp",insertable=false, updatable=false )
    private Dieta alimentosperm;
    @Column(name = "iddietasp" )
    private int iddietasp;


    @OneToOne()
    @JoinColumn(name = "idalimentos" )
    private Alimentos alimentos;



    @Column(name = "cantidad")
    private int cantidad;
}

