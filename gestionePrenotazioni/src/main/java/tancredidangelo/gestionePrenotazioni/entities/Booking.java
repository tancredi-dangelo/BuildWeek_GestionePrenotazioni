package tancredidangelo.gestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tancredidangelo.gestionePrenotazioni.enums.BookingStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "workstation_id", nullable = false)
    private Workstation workstation;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "booked_at", nullable = false)
    private LocalDateTime bookedAt;

    @Column(name = "number_of_people", nullable = false)
    private int numberOfPeople;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    private BookingStatus bookingStatus;


    // constructor

    public Booking(Workstation workstation, User user, int numberOfPeople) {
        this.workstation = workstation;
        this.user = user;
        this.numberOfPeople = numberOfPeople;

        this.bookingStatus = BookingStatus.BOOKED;
        this.bookedAt = LocalDateTime.now();
    }


    // to string

    @Override
    public String toString() {
        return "\n---BOOKING CONFIRMED.---" +
                "\nBooking{" +
                "bookingId = " + bookingId +
                ", workstation = " + workstation +
                ", user = " + user +
                ", bookedAt = " + bookedAt +
                ", numberOfPeople = " + numberOfPeople +
                ", bookingStatus = " + bookingStatus +
                '}';
    }
}
