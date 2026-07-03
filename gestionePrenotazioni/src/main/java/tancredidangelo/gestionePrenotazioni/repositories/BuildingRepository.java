package tancredidangelo.gestionePrenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tancredidangelo.gestionePrenotazioni.entities.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
