package app.consultorio.odontologico.controllers;


import app.consultorio.odontologico.dtos.OdontologistDTO;
import app.consultorio.odontologico.exceptions.ApiException;
import app.consultorio.odontologico.services.OdontologistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class OdontologistController {
    private OdontologistService service;

    public OdontologistController(OdontologistService service) {
        this.service = service;
    }
    /**
     * Put endpoint /odontologist
     *
     * @param odontologist Odontologist dto
     * @return a ResponseEntity with the save result
     */
    @PutMapping("/odontologist")
    public ResponseEntity<OdontologistDTO> putOdontologist(@RequestBody OdontologistDTO odontologist) throws ApiException {
        return new ResponseEntity<OdontologistDTO>(this.service.saveOdontologist(odontologist), HttpStatus.OK);
    }

    /**
     * Post endpoint /odontologist
     *
     * @param odontologist Odontologist dto
     * @return a ResponseEntity with the save result
     */
    @PostMapping("/odontologist")
    public ResponseEntity<OdontologistDTO> odontologist(@RequestBody OdontologistDTO odontologist) throws ApiException {
        return new ResponseEntity<OdontologistDTO>(this.service.saveOdontologist(odontologist), HttpStatus.OK);
    }

    /**
     * GET endpoint /odontologists
     *
     * @return a odontologist list
     */
    @GetMapping("/odontologists")
    public ResponseEntity<List<OdontologistDTO>> odontologists() throws ApiException {
        return new ResponseEntity<List<OdontologistDTO>>(this.service.getOdontologists(), HttpStatus.OK);
    }

    /**
     * GET endpoint /odontologist/id
     *
     * @param id the id of the odontologist
     * @return a odontologist
     * */
    @GetMapping("/odontologist/{id}")
    public ResponseEntity<OdontologistDTO> odontologist(@PathVariable Long id) throws ApiException {
        return new ResponseEntity<OdontologistDTO>(this.service.findOdontologist(id), HttpStatus.OK);
    }

    /**
     * DELETE endpoint /odontologist/id
     *
     * @param id the id of the odontologist
     */
    @DeleteMapping("/odontologist/{id}")
    public ResponseEntity deleteOdontologists(@PathVariable Long id) throws ApiException {
        this.service.deleteOdontologist(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
