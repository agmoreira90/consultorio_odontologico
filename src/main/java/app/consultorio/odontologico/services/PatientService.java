package app.consultorio.odontologico.services;


import app.consultorio.odontologico.dtos.PatientDTO;
import app.consultorio.odontologico.entities.Patient;
import app.consultorio.odontologico.exceptions.ApiException;
import app.consultorio.odontologico.repository.IPatientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService {

    public final IPatientRepository repository;

    public PatientService(IPatientRepository studentRepository) {
        this.repository = studentRepository;
    }

    private ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional
    public PatientDTO savePatient(PatientDTO patient) {
        if (patient.getId() != null) {
            Boolean isExists = this.repository.existsById(patient.getId());
            if (isExists) {
                Patient patientAux = this.repository.getOne(patient.getId());
                patientAux = mapper.map(patient, Patient.class);
                patient = mapper.map(this.repository.save(patientAux),PatientDTO.class);
            } else {
                Patient patientAux = mapper.map(patient, Patient.class);
                patient = mapper.map(this.repository.save(patientAux),PatientDTO.class);
            }
        } else {
            Patient patientAux = mapper.map(patient, Patient.class);
            patient = mapper.map(this.repository.save(patientAux),PatientDTO.class);
        }
        return patient;
    }

    @Override
    @Transactional
    public void deletePatient(Long id) throws ApiException {
        Boolean isExists = this.repository.existsById(id);
        if (isExists) {
            repository.deleteById(id);
        } else {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Error: The Patient id does not Exist.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PatientDTO findPatient(Long id) throws ApiException {
        Boolean isExists = this.repository.existsById(id);
        if (isExists) {
            Patient patient = repository.findById(id).orElse(null);
            PatientDTO patientDTO = mapper.map(patient, PatientDTO.class);
            return patientDTO;
        } else {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Error: The Patient id does not Exist.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientDTO> getPatients() {
        List<Patient> patients = this.repository.findAll();
        List<PatientDTO> patientList = mapper.map(patients, new TypeToken<ArrayList<Patient>>() {
        }.getType());
        return patientList;
    }
}
