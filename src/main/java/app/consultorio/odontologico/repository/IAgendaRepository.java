package app.consultorio.odontologico.repository;

import app.consultorio.odontologico.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgendaRepository extends JpaRepository<Agenda, Long>{
}
