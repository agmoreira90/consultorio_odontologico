package app.consultorio.odontologico.services;


import app.consultorio.odontologico.dtos.AgendaDTO;
import app.consultorio.odontologico.dtos.AppointmentDTO;
import app.consultorio.odontologico.dtos.PatientDTO;
import app.consultorio.odontologico.entities.Agenda;
import app.consultorio.odontologico.entities.Appointment;
import app.consultorio.odontologico.exceptions.ApiException;
import app.consultorio.odontologico.repository.IAppointmentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {

    private AgendaService agendaService;

    private PatientService patientService;

    private IAppointmentRepository repository;

    private ModelMapper mapper = new ModelMapper();

    public AppointmentService(AgendaService agendaService, PatientService patientService, IAppointmentRepository repository) {
        this.agendaService = agendaService;
        this.patientService = patientService;
        this.repository = repository;
    }

    @Override
    public AppointmentDTO saveAppointment(AppointmentDTO appointment) throws ApiException {
        if (appointment.getId() != null) {
            Boolean isExists = this.repository.existsById(appointment.getId());
            if (isExists) {
                Appointment appointmentAux = this.repository.getOne(appointment.getId());
                appointmentAux = mapper.map(appointment, Appointment.class);
                appointment = mapper.map(this.repository.save(appointmentAux), AppointmentDTO.class);
            } else {
                Appointment appointmentAux = mapper.map(appointment, Appointment.class);
                appointment = mapper.map(this.repository.save(appointmentAux), AppointmentDTO.class);
            }
        } else {
            AgendaDTO agenda = agendaService.findAgenda(appointment.getAgenda().getId());
            PatientDTO patient = patientService.findPatient(appointment.getPatient().getId());
            appointment.setAgenda(agenda);
            appointment.setPatient(patient);
            Appointment appointmentAux = mapper.map(appointment, Appointment.class);
            appointment = mapper.map(this.repository.save(appointmentAux), AppointmentDTO.class);
        }
        return appointment;
    }

    @Override
    public void deleteAppointment(Long id) throws ApiException {
        Boolean isExists = this.repository.existsById(id);
        if (isExists) {
            this.repository.deleteById(id);
        } else {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Error: The Appointment id does not Exist.");
        }
    }

    @Override
    public AppointmentDTO findAppointmentById(Long id) throws ApiException {
        Boolean isExists = this.repository.existsById(id);
        if (isExists) {
            Appointment appointmentAux = this.repository.getOne(id);
            AppointmentDTO appointment = mapper.map(appointmentAux, AppointmentDTO.class);
            return appointment;
        } else {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Error: The Appointment id does not Exist.");
        }
    }

    @Override
    public List<AppointmentDTO> findAllAppointments() {
        List<Appointment> appointments = this.repository.findAll();
        List<AppointmentDTO> appointmentLits = mapper.map(appointments, new TypeToken<ArrayList<AppointmentDTO>>() {
        }.getType());
        return appointmentLits;
    }
}
