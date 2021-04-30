package app.consultorio.odontologico.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Odontologist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dni;
    private String name;
    private String lastName;
    @JsonIgnore
    @OneToMany(mappedBy = "odontologist")
    private Set<Agenda> agenda;
}
