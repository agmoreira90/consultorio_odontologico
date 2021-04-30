package app.consultorio.odontologico.repository;

import app.consultorio.odontologico.entities.Odontologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologistRepository extends JpaRepository<Odontologist,Long> {
//    @Query("SELECT o FROM Odontologist o WHERE ")
//    List<OdontologistDTO> findOdontologistByDate(Date date);
}
