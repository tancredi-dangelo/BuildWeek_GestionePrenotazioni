package tancredidangelo.gestionePrenotazioni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tancredidangelo.gestionePrenotazioni.entities.Workstation;
import tancredidangelo.gestionePrenotazioni.enums.WorkstationStatus;
import tancredidangelo.gestionePrenotazioni.enums.WorkstationType;

import java.util.List;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {

    /// find by id
    Workstation findWorkstationById(Long Id);

    /// 1) find workstation by city [ workstation -> building -> city ]
    @Query("""
            SELECT w FROM Workstation w WHERE w.building.city = :city
            """)
    List<Workstation> findWorkstationByCity(@Param("city") String city);



    /// 2) find workstation by N-people capacity
    @Query("""
            SELECT w FROM Workstation w WHERE w.maxNumOfPeople < :n
            """)
    List<Workstation> findWorkstationByNumOfPeople(@Param("n") int n);



    /// 3) find workstation by type (openspace, room, private)
    @Query("""
            SELECT w FROM Workstation w WHERE w.workstationType = :type
            """)
    List<Workstation> findWorkstationByType(@Param("type") WorkstationType type);



    /// 4) find workstation by status (free, busy)
    @Query("""
            SELECT w FROM Workstation w WHERE w.workstationStatus = :status
           """)
    List<Workstation> findWorkstationByStatus(@Param("status") WorkstationStatus status);

}

