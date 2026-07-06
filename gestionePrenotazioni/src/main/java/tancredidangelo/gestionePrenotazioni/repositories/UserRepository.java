package tancredidangelo.gestionePrenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tancredidangelo.gestionePrenotazioni.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //// derived queries

    User findUserById(Long userId);

    List<User> findUserByEmail(String email);

    List<User> findUserByName(String name);

    List<User> findUserBySurname(String surname);


    //// custom queries

    // TODO: find users with active bookings
    // List<User> findUsersWithActiveBookings


}
