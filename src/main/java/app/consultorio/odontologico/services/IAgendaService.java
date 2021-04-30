package app.consultorio.odontologico.services;



import app.consultorio.odontologico.dtos.AgendaDTO;
import app.consultorio.odontologico.exceptions.ApiException;

import java.util.List;

public interface IAgendaService {

    AgendaDTO saveAgenda(AgendaDTO agenda);

    void deleteAgenda(Long id) throws ApiException;

    AgendaDTO findAgenda(Long id) throws ApiException;

    List<AgendaDTO> getAllAgendas();
}
