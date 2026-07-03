package tancredidangelo.gestionePrenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tancredidangelo.gestionePrenotazioni.entities.Workstation;

public interface BookingRepository extends JpaRepository<Workstation, Long> {
}
