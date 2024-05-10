package org.example.restserver.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="coachee")
public class Coachee {
    public static final String IDCOACHEE = "idcoachee";
    @Id
    @Column(name = IDCOACHEE, nullable = false)
    private int idcoachee;


    @Column(name = "username")
    private String username;
    @Column(name = "idcoach")
    private int idcoach;
    @Column(name = "objetivos")
    private String objetivos;


}
