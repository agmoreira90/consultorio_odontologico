package app.consultorio.odontologico.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="odontologist_id")
    private Odontologist odontologist;
    @JsonIgnore
    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY)
    private Set<Appointment> appointments;

    public String getDate() {
        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public void setDate(String date) throws ParseException {
        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        this.date = sdf.parse(date);
    }
}
