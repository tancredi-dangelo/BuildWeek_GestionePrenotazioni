package tancredidangelo.gestionePrenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tancredidangelo.gestionePrenotazioni.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
