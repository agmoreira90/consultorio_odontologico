package app.consultorio.odontologico.services;



import app.consultorio.odontologico.dtos.AppointmentDTO;
import app.consultorio.odontologico.exceptions.ApiException;

import java.util.List;

public interface IAppointmentService {
    AppointmentDTO saveAppointment(AppointmentDTO appointment)throws ApiException;
    void deleteAppointment(Long id) throws ApiException;
    AppointmentDTO findAppointmentById(Long id) throws ApiException;
    List<AppointmentDTO> findAllAppointments();
}
