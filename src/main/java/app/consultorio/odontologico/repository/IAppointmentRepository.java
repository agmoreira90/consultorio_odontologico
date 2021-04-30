package app.consultorio.odontologico.repository;

import app.consultorio.odontologico.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
}
