package app.consultorio.odontologico.services;


import app.consultorio.odontologico.dtos.OdontologistDTO;
import app.consultorio.odontologico.exceptions.ApiException;

import java.util.List;

public interface IOdontologistService {
    List<OdontologistDTO> getOdontologists() throws ApiException;
    OdontologistDTO saveOdontologist(OdontologistDTO odontologist)throws ApiException;
    OdontologistDTO findOdontologist(Long id)throws ApiException;
    void deleteOdontologist(Long id)throws ApiException;
}
