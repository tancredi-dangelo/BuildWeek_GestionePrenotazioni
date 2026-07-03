package tancredidangelo.gestionePrenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tancredidangelo.gestionePrenotazioni.entities.Building;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
