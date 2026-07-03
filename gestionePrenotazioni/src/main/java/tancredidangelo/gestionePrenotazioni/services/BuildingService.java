package tancredidangelo.gestionePrenotazioni.services;

import org.springframework.stereotype.Service;
import tancredidangelo.gestionePrenotazioni.entities.Building;
import tancredidangelo.gestionePrenotazioni.repositories.BuildingRepository;


import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {


    // dependency injection
    private final BuildingRepository buildingRepository;

    // constructor
    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }



    // --------- METHODS ------------------------------------------------------------

    public Optional<Building> findBuildingById(Long id) {
        return this.buildingRepository.findById(id);
    }


    public List<Building> findAllBuildings() {
        return this.buildingRepository.findAll();
    }


    public void saveBuilding(Building building) {
        this.buildingRepository.save(building);
        System.out.println("Building '" + building.getBuildingName() + "' successfully saved in database.");
    }


    public void deleteBuildingById(Long id) {
        Optional<Building> buildingFound = findBuildingById(id);
        if (buildingFound.isPresent()) {
            this.buildingRepository.delete(buildingFound.get());
            System.out.println("\nBuilding successfully deleted from database.");
        }
        else System.out.println("\nNo building with the provided ID was found in database.");
    }


    public void deleteAllBuildings() {
        this.buildingRepository.deleteAll();
    }


}

