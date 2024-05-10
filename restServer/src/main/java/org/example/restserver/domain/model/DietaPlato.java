package org.example.restserver.domain.model;

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
@Table(name ="dieta_plato")
public class DietaPlato {
    @EmbeddedId
    private DietaPlatoId id;
    @MapsId("iddieta")
    private int idDieta;

    @MapsId("idplato")
    private int idplato;

}
