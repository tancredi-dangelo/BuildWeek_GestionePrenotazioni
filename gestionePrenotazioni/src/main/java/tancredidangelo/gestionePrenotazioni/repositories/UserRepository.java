package tancredidangelo.gestionePrenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tancredidangelo.gestionePrenotazioni.entities.User;
import tancredidangelo.gestionePrenotazioni.enums.BookingStatus;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // derived queries

    public List<User> findByEmail(String email);

    public List<User> findByName(String name);

    public List<User> findBySurname(String surname);




}
