package tancredidangelo.gestionePrenotazioni.services;

import org.springframework.stereotype.Service;
import tancredidangelo.gestionePrenotazioni.entities.Booking;
import tancredidangelo.gestionePrenotazioni.entities.User;
import tancredidangelo.gestionePrenotazioni.entities.Workstation;
import tancredidangelo.gestionePrenotazioni.enums.WorkstationStatus;
import tancredidangelo.gestionePrenotazioni.repositories.BookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // --------- METHODS ------------------------------------------------------------

    public Optional<Booking> findBookingById(Long id) {
        return this.bookingRepository.findById(id);
    }

    public List<Booking> findAllBookings() {
        return this.bookingRepository.findAll();
    }

    public void saveBooking(Booking booking) {
        Booking saved = this.bookingRepository.save(booking);
        System.out.println("Booking successfully saved in database.");
    }

    public void deleteBookingById(Long id) {
        Optional<Booking> bookingFound = findBookingById(id);
        if (bookingFound.isPresent()) {
            this.bookingRepository.delete(bookingFound.get());
            System.out.println("Booking successfully deleted from database.");
        } else {
            System.out.println("\nNo booking with the provided ID was found in database.");
        }
    }

    public void deleteAllBookings() {
        this.bookingRepository.deleteAll();
    }


    public void bookWorkstation(User user, Workstation workstation, int nPeople) {
        if (workstation.getWorkstationStatus() == WorkstationStatus.FREE) {
            Booking newBooking = new Booking(workstation, user, nPeople);
            this.bookingRepository.save(newBooking);
            workstation.setWorkstationStatus(WorkstationStatus.BUSY);
            System.out.println(newBooking);

        } else {
            System.out.println("This workstation is currently booked. Try again later.");
        }
    }
}