package tancredidangelo.gestionePrenotazioni.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tancredidangelo.gestionePrenotazioni.entities.Workstation;
import tancredidangelo.gestionePrenotazioni.populateDB.PopulateDatabase;
import tancredidangelo.gestionePrenotazioni.services.BookingService;
import tancredidangelo.gestionePrenotazioni.services.BuildingService;
import tancredidangelo.gestionePrenotazioni.services.WorkstationService;

@Component
public class MainRunner implements CommandLineRunner
{

    // dependancy injection
    private final PopulateDatabase populateDatabase;
    private final BookingService bookingService;
    private final BuildingService buildingService;
    private final WorkstationService workstationService;

    public MainRunner(PopulateDatabase populateDatabase, BookingService bookingService, BuildingService buildingService, WorkstationService workstationService) {
        this.populateDatabase = populateDatabase;
        this.bookingService = bookingService;
        this.buildingService = buildingService;
        this.workstationService = workstationService;
    }


    @Override
    public void run(String... args) throws Exception {

        populateDatabase.populateBuildingsAndWorkstations();
        populateDatabase.populateUsers();

        Workstation workstation1 = workstationService.
        bookingService.bookWorkstation();


    }

}
