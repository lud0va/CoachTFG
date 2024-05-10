package org.example.restserver.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.restserver.common.Constantes;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = Constantes.USERR)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constantes.IDUSER, nullable = false)
    private int id;
    @Column(name = Constantes.EMAIL)
    private String email;
    @Column(name = Constantes.PASSWORD)
    private String password;
    @Column(name = Constantes.NAME)
    private String name;
    @Column(name = Constantes.LASTNAME)
    private String lastname;
    @Column(name = Constantes.ROL)
    private String rol;

    public Users(String email, String password, String name, String lastname, String rol) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.rol = rol;
    }
}
