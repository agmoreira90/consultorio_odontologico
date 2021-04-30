package app.consultorio.odontologico.services;


import app.consultorio.odontologico.dtos.AgendaDTO;
import app.consultorio.odontologico.entities.Agenda;
import app.consultorio.odontologico.exceptions.ApiException;
import app.consultorio.odontologico.repository.IAgendaRepository;
import app.consultorio.odontologico.repository.IOdontologistRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaService implements IAgendaService {

    private final IAgendaRepository repository;
    private final IOdontologistRepository odontologistRepository;
    private ModelMapper mapper = new ModelMapper();

    public AgendaService(IAgendaRepository repository, IOdontologistRepository odontologistRepository) {
        this.repository = repository;
        this.odontologistRepository = odontologistRepository;
    }

    @Override
    @Transactional
    public AgendaDTO saveAgenda(AgendaDTO agenda) {
        if (agenda.getId() != null) {
            Boolean isExists = this.repository.existsById(agenda.getId());
            if (isExists) {
                Agenda agendaAux = this.repository.getOne(agenda.getId());
                agendaAux = mapper.map(agenda, Agenda.class);
                agenda = mapper.map(this.repository.save(agendaAux), AgendaDTO.class);
            } else {
                Agenda agendaAux = mapper.map(agenda, Agenda.class);
                agenda = mapper.map(this.repository.save(agendaAux), AgendaDTO.class);
            }
        } else {
            Agenda agendaAux = mapper.map(agenda, Agenda.class);
            agenda = mapper.map(this.repository.save(agendaAux), AgendaDTO.class);
        }
        return agenda;
    }

    @Override
    @Transactional
    public void deleteAgenda(Long id) throws ApiException {
        Boolean isExists = this.repository.existsById(id);
        if (isExists) {
            this.repository.deleteById(id);
        } else {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Error: The Appointment id does not Exist.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public AgendaDTO findAgenda(Long id) throws ApiException {
        Boolean isExists = this.repository.existsById(id);
        if (isExists) {
            Agenda agenda = this.repository.getOne(id);
            AgendaDTO agendaDto = mapper.map(agenda, AgendaDTO.class);
            return agendaDto;
        } else {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Error: The Appointment id does not Exist.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgendaDTO> getAllAgendas() {
        List<Agenda> agendas = this.repository.findAll();
        List<AgendaDTO> agendaList = mapper.map(agendas, new TypeToken<ArrayList<AgendaDTO>>() {
        }.getType());
        return agendaList;
    }
}
