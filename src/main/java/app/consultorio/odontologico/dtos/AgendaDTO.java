package app.consultorio.odontologico.dtos;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(include=JsonSerialize.Inclusion.NON_EMPTY)
public class AgendaDTO {
    private Long id;
    private Date date;
    private OdontologistDTO odontologist;
    private List<AppointmentDTO> appointments;

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
