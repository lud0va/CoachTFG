package org.example.restserver.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DietaPlatoId   implements Serializable {
    @Column(name = "iddieta")
    private int idDieta;

    @Column(name = "idplato")
    private int idplato;

}
