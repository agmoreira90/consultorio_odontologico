package app.consultorio.odontologico.controllers;


import app.consultorio.odontologico.dtos.AppointmentDTO;
import app.consultorio.odontologico.exceptions.ApiException;
import app.consultorio.odontologico.services.IAppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AppointmentController {

    private IAppointmentService service;

    public AppointmentController(IAppointmentService service) {
        this.service = service;
    }

    /**
     * POST create a new appointment
     *
     * @param appointment request appointment
     * @return created appointment
     */
    @PostMapping("/appointment")
    private ResponseEntity<AppointmentDTO> saveAppointment(@RequestBody AppointmentDTO appointment) throws ApiException {
        return new ResponseEntity<AppointmentDTO>(service.saveAppointment(appointment), HttpStatus.CREATED);
    }

    /**
     * PUT update an appointment
     *
     * @param appointment request appointment
     * @return created appointment
     */
    @PutMapping("/appointment")
    private ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody AppointmentDTO appointment) throws ApiException {
        return new ResponseEntity<AppointmentDTO>(service.saveAppointment(appointment), HttpStatus.OK);
    }

    /**
     * GET endpoint /appointments
     *
     * @return a Appointment list
     */
    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDTO>> appointments() throws ApiException {
        return new ResponseEntity<List<AppointmentDTO>>(this.service.findAllAppointments(), HttpStatus.OK);
    }

    /**
     * GET endpoint /appointment/id
     *
     * @param id the id of the appointment
     * @return a appointment list
     */
    @GetMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDTO> odontologist(@PathVariable Long id) throws ApiException {
        return new ResponseEntity<AppointmentDTO>(this.service.findAppointmentById(id), HttpStatus.OK);
    }

    /**
     * DELETE endpoint /appointment/id
     *
     * @param id the id of the appointment
     */
    @DeleteMapping("/appointment/{id}")
    public ResponseEntity deleteAppointment(@PathVariable Long id) throws ApiException {
        this.service.deleteAppointment(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
