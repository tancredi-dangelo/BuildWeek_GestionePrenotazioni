package tancredidangelo.gestionePrenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tancredidangelo.gestionePrenotazioni.entities.Booking;
import tancredidangelo.gestionePrenotazioni.entities.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    /// find booking by user
    List<Booking> FindBookingByUser(User user);

    /// find booking by id
    List<Booking> FindBookingById(Long bookingId);



    // TODO: create a booking

}
