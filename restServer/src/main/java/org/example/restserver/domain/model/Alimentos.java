package org.example.restserver.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.restserver.common.Constantes;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Constantes.ALIMENTOS)
public class Alimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constantes.IDALIMENTOS, nullable = false)
    private int id;

    @Column(name = Constantes.NOMBRE)
    private String nombre;
    @Column(name = Constantes.DESC)
    private String desc;
    @Column(name = Constantes.CALORIAS)
    private int calorias;
    @Column(name = Constantes.GRASAS)
    private int grasas;
    @Column(name = Constantes.CARBOHIDRATOS)
    private int carbohidratos;
    @Column(name = Constantes.PROTEINAS)
    private int proteinas;
    @Column(name = Constantes.VITAMINAS)
    private int vitaminas;
    @Column(name = Constantes.MINERALES)
    private int minerales;


}
