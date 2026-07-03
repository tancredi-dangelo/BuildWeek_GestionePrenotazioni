package tancredidangelo.gestionePrenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tancredidangelo.gestionePrenotazioni.entities.Workstation;

import java.util.List;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {


    // derived query
    public List<Workstation> findByCity(String city);
}
