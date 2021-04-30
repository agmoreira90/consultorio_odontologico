package app.consultorio.odontologico.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dni;
    private String name;
    private String lastName;
}

