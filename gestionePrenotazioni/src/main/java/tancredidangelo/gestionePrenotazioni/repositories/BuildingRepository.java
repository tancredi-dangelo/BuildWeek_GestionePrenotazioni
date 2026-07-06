package tancredidangelo.gestionePrenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tancredidangelo.gestionePrenotazioni.entities.Building;
import tancredidangelo.gestionePrenotazioni.enums.WorkstationType;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {

    /// find building by city
    List<Building> findByCity(String city);

    /// find buildings that have at least one openspace
    @Query("""
        SELECT b FROM Building b JOIN b.workstations w WHERE w.workstationType = :workstationType
        """)
    List<Building> findBuildingByTypeOfWorkstation(@Param("workstationType") WorkstationType workstationType);


    /// find buildings that have at least one workstation with N-people capacity
    @Query("""
            SELECT b FROM Building b JOIN b.workstations w WHERE w.maxNumOfPeople = :n
        """)
    List<Building> findBuildingByMaxNumOfPeople(@Param("workstationType") int n);


}
