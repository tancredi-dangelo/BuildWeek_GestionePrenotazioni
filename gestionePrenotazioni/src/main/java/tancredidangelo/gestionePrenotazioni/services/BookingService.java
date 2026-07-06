package tancredidangelo.gestionePrenotazioni.services;

import org.springframework.stereotype.Service;
import tancredidangelo.gestionePrenotazioni.entities.Booking;
import tancredidangelo.gestionePrenotazioni.repositories.BookingRepository;
import tancredidangelo.gestionePrenotazioni.repositories.UserRepository;
import tancredidangelo.gestionePrenotazioni.repositories.WorkstationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final WorkstationRepository workstationRepository;

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository, WorkstationRepository workstationRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.workstationRepository = workstationRepository;
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


    /// create a booking

    public void bookWorkstation(Long userId, Long workstationId, int nPeople, LocalDate date) {

        List<Booking> workstationBookings = workstationRepository.findWorkstationById(workstationId).getBookings();
        List<Booking> userBookings = userRepository.findUserById(userId).getActiveBookings();

        if (userBookings.stream().anyMatch(booking -> booking.getDate().isEqual(date))) {
            System.out.println("\nThis user already has a booking for that date. Choose another date");
            return;
        }

        if (workstationBookings.stream().anyMatch(booking -> booking.getDate().isEqual(date))) {
            System.out.println("\nThis workstation already booked for the provided date. Choose another date.");
            return;
        }

        if (nPeople > workstationRepository.findWorkstationById(workstationId).getMaxNumOfPeople()) {
            System.out.println("\nThis workstation doesn't have enough capacity for the number of people provided. Choose another workstation.");
        }

        else {
            Booking newBooking = new Booking(workstationId, userId, nPeople, date);
            this.bookingRepository.save(newBooking);
            System.out.println(newBooking);
        }
    }
}