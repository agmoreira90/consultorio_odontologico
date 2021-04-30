package app.consultorio.odontologico.controllers;


import app.consultorio.odontologico.dtos.AgendaDTO;
import app.consultorio.odontologico.exceptions.ApiException;
import app.consultorio.odontologico.services.AgendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgendaController {

    private AgendaService service;

    public AgendaController(AgendaService agendaService) {
        this.service = agendaService;
    }
    /**
     * POST create a new Agenda
     *
     * @param  agenda Agenda
     * @return created Agenda
     */
    @PostMapping("/agenda")
    private ResponseEntity<AgendaDTO> saveAgenda(@RequestBody AgendaDTO agenda) throws ApiException {
        return new ResponseEntity<AgendaDTO>(service.saveAgenda(agenda), HttpStatus.CREATED);
    }

    /**
     * PUT update an Agenda
     *
     * @param agenda request Agenda
     * @return updated Agenda
     */
    @PutMapping("/agenda")
    private ResponseEntity<AgendaDTO> updateAppointment(@RequestBody AgendaDTO agenda) throws ApiException {
        return new ResponseEntity<AgendaDTO>(service.saveAgenda(agenda), HttpStatus.OK);
    }

    /**
     * GET endpoint /agendas
     *
     * @return a Agenda list
     */
    @GetMapping("/agendas")
    public ResponseEntity<List<AgendaDTO>> appointments() throws ApiException {
        return new ResponseEntity<List<AgendaDTO>>(this.service.getAllAgendas(), HttpStatus.OK);
    }

    /**
     * GET endpoint /agenda/id
     *
     * @param id the id of the Agenda
     * @return an Agenda
     */
    @GetMapping("/agenda/{id}")
    public ResponseEntity<AgendaDTO> odontologist(@PathVariable Long id) throws ApiException {
        return new ResponseEntity<AgendaDTO>(this.service.findAgenda(id), HttpStatus.OK);
    }

    /**
     * DELETE endpoint /agenda/id
     *
     * @param id the id of the Agenda
     */
    @DeleteMapping("/agenda/{id}")
    public ResponseEntity deleteAppointment(@PathVariable Long id) throws ApiException {
        this.service.deleteAgenda(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
