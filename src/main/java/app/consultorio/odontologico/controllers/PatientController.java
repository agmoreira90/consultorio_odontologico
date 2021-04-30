package app.consultorio.odontologico.controllers;


import app.consultorio.odontologico.dtos.OdontologistDTO;
import app.consultorio.odontologico.dtos.PatientDTO;
import app.consultorio.odontologico.entities.Patient;
import app.consultorio.odontologico.exceptions.ApiException;
import app.consultorio.odontologico.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    private IPatientService service;

    public PatientController(IPatientService service) {
        this.service = service;
    }

    /**
     * Put endpoint /patient
     *
     * @param patient Patient dto
     * @return a ResponseEntity with the save result
     */
    @PutMapping("/patient")
    public ResponseEntity<PatientDTO> putOdontologist(@RequestBody PatientDTO patient) throws ApiException {
        return new ResponseEntity<PatientDTO>(this.service.savePatient(patient), HttpStatus.OK);
    }

    /**
     * Post endpoint /patient
     *
     * @param patient Patient dto
     * @return a ResponseEntity with the save result
     */
    @PostMapping("/patient")
    public ResponseEntity<PatientDTO> odontologist(@RequestBody PatientDTO patient) throws ApiException {
        return new ResponseEntity<PatientDTO>(this.service.savePatient(patient), HttpStatus.OK);
    }

    /**
     * GET endpoint /patients
     *
     * @return a Patients list
     */
    @GetMapping("/patients")
    public ResponseEntity<List<PatientDTO>> odontologists() throws ApiException {
        return new ResponseEntity<List<PatientDTO>>(this.service.getPatients(), HttpStatus.OK);
    }

    /**
     * GET endpoint /pstient/id
     *
     * @param id the id of the patient
     * @return a Pttient
     */
    @GetMapping("/patient/{id}")
    public ResponseEntity<PatientDTO> odontologist(@PathVariable Long id) throws ApiException {
        return new ResponseEntity<PatientDTO>(this.service.findPatient(id), HttpStatus.OK);
    }

    /**
     * DELETE endpoint /patient/id
     *
     * @param id the id of the Patient
     */
    @DeleteMapping("/patient/{id}")
    public ResponseEntity deleteOdontologists(@PathVariable Long id) throws ApiException {
        this.service.deletePatient(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
