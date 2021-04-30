package app.consultorio.odontologico.utils;

import app.consultorio.odontologico.exceptions.ApiException;
import org.springframework.http.HttpStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date getDateFromString(String stringDate) throws ApiException {
        Date date = null;
        String format = "dd/MM/yyyy 'at' HH:mm";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(stringDate);
            if (!stringDate.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "The date " + stringDate + " must have the format " + format);
        }
        return date;
    }

}
