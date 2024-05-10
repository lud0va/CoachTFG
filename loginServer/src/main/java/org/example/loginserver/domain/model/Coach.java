package org.example.loginserver.domain.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.loginserver.common.Constantes;


import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Constantes.COACH)
public class Coach {


    @Id
    @Column(name = Constantes.IDCOACH, nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = Constantes.CODE)
    private String coachCode;
    @Column(name = Constantes.FECHA_EXP_LICENCIA)
    private LocalDate fechaExp;

    public Coach(int id,String name, String lastname, String coachCode) {
        this.name = name;
        this.lastname = lastname;
        this.coachCode = coachCode;
        fechaExp=LocalDate.now().plusMonths(4);
    }

    public Coach(int id, String coachCode) {
        this.id = id;
        this.coachCode=coachCode;
        fechaExp=LocalDate.now().plusMonths(4);
    }
}
