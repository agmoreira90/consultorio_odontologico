package app.consultorio.odontologico.services;

import app.consultorio.odontologico.dtos.PatientDTO;
import app.consultorio.odontologico.exceptions.ApiException;

import java.util.List;

public interface IPatientService {
    PatientDTO savePatient(PatientDTO student) throws ApiException;

    void deletePatient(Long id) throws ApiException;

    PatientDTO findPatient(Long id) throws ApiException;

    List<PatientDTO> getPatients() throws ApiException;

}
