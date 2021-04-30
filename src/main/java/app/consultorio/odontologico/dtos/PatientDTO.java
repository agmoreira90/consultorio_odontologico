package app.consultorio.odontologico.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)
public class PatientDTO {
    private Long id;
    private String dni;
    private String name;
    private String lastName;
}
