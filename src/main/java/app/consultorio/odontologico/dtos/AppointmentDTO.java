package app.consultorio.odontologico.dtos;


import app.consultorio.odontologico.entities.Agenda;
import app.consultorio.odontologico.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDTO {

    private Long id;
    private PatientDTO patient;
    private String status;
    private AgendaDTO agenda;
    private Date timeFrom;
    private Date timeTo;
}
