package tancredidangelo.gestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> activeBookings;


    // constructor

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.username = name+"_"+surname;
        this.email = email;
    }


    // to string


    @Override
    public String toString() {
        return "\nUser {" +
                "userId = " + userId +
                ", name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", username = " + username +
                ", email = '" + email + '\'' +
                ", activeBookings = " + activeBookings +
                '}';
    }
}
