package tancredidangelo.gestionePrenotazioni.services;

import org.springframework.stereotype.Service;
import tancredidangelo.gestionePrenotazioni.entities.Workstation;
import tancredidangelo.gestionePrenotazioni.enums.WorkstationStatus;
import tancredidangelo.gestionePrenotazioni.enums.WorkstationType;
import tancredidangelo.gestionePrenotazioni.repositories.WorkstationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkstationService {

    // dependency injection
    private final WorkstationRepository workstationRepository;

    // constructor
    public WorkstationService(WorkstationRepository workstationRepository) {
        this.workstationRepository = workstationRepository;
    }



    // --------- METHODS ------------------------------------------------------------

    public Optional<Workstation> findWorkstationById(Long id) {
        return this.workstationRepository.findById(id);
    }


    public List<Workstation> findAllWorkstations() {
        return this.workstationRepository.findAll();
    }


    public void saveWorkstation(Workstation workstation) {
        this.workstationRepository.save(workstation);
        System.out.println("\nWorkstation '" + workstation.getDescription() + "' successfully saved in database.");
    }


    public void deleteWorkstationById(Long id) {
        Optional<Workstation> workstationFound = findWorkstationById(id);
        if (workstationFound.isPresent()) {
            this.workstationRepository.delete(workstationFound.get());
            System.out.println("\nWorkstation successfully deleted from database.");
        }
        else System.out.println("\nNo workstation with the provided ID was found in database.");
    }


    public void deleteAllWorkstations() {
        this.workstationRepository.deleteAll();
    }


    public List<Workstation> findWorkstationByCity(String city) {
        return workstationRepository.findWorkstationByCity(city);
    }


    public List<Workstation> findWorkstationByNumOfPeople(int n) {
        return workstationRepository.findWorkstationByNumOfPeople(n);
    }

    public List<Workstation> findWorkstationByType(WorkstationType workstationType) {
        return workstationRepository.findWorkstationByType(workstationType);
    }

    public List<Workstation> findWorkstationByStatus(WorkstationStatus workstationStatus) {
        return  workstationRepository.findWorkstationByStatus(workstationStatus);
    }



}
