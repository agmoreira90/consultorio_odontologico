package app.consultorio.odontologico.dtos;

import app.consultorio.odontologico.entities.Agenda;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class OdontologistDTO {
    private Long id;
    private String dni;
    private String name;
    private String lastName;
}
