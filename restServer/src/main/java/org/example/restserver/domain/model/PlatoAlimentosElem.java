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
@Table(name ="plato_alimentoselem")
public class PlatoAlimentosElem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idplatoalimentos", nullable = false)
  private int id;
  @JsonIgnore
  @ManyToOne(cascade = {CascadeType.REMOVE} )
  @JoinColumn(name = "idplatos",insertable=false, updatable=false)
  private Plato alimentosPlato;
  @Column(name = "idplatos")
  private int idplatos;

  @OneToOne(cascade = {CascadeType.REMOVE})
  @JoinColumn(name = "idalimentos" )
  private Alimentos alimento;


}
