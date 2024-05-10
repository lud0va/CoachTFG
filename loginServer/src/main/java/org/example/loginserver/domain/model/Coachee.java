package org.example.loginserver.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.loginserver.common.Constantes;

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


}
