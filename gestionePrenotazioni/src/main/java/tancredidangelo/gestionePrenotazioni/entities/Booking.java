package tancredidangelo.gestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tancredidangelo.gestionePrenotazioni.enums.BookingStatus;

import java.time.LocalDate;

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
    @JoinColumn(name = "workstation_id", nullable = false, insertable = false, updatable = false)
    private Workstation workstation;

    @Column(name = "workstation_id", nullable = false)
    private Long workstationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private User user;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "number_of_people", nullable = false)
    private int numberOfPeople;

    @Enumerated(EnumType.STRING)
    @Column(name = "booking_status", nullable = false)
    @Getter(AccessLevel.NONE)
    private BookingStatus bookingStatus;


    @Column(name = "date_of_booking")
    private LocalDate date;



    // constructor

    public Booking(Long workstationId, Long userId, int numberOfPeople, LocalDate date) {
        this.workstationId = workstationId;
        this.userId = userId;
        this.numberOfPeople = numberOfPeople;
        this.bookingStatus = BookingStatus.BOOKED;
        this.date = date;
    }


    // to string

    @Override
    public String toString() {
        return "\n---BOOKING CONFIRMED.---" +
                "\nBooking{" +
                "bookingId = " + bookingId +
                ", workstation = " + workstation +
                ", user = " + user +
                ", numberOfPeople = " + numberOfPeople +
                ", bookingStatus = " + bookingStatus +
                '}';
    }
}
