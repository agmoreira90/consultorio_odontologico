package app.consultorio.odontologico.entities;

import lombok.Data;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Patient patient;
    private String status;
    @OneToOne//(mappedBy = "id",fetch = FetchType.LAZY)
    private Agenda agenda;
    private Date timeFrom;
    private Date timeTo;
}
