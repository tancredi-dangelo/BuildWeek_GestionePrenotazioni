package tancredidangelo.gestionePrenotazioni.runners;

import org.hibernate.jdbc.Work;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tancredidangelo.gestionePrenotazioni.entities.User;
import tancredidangelo.gestionePrenotazioni.entities.Workstation;
import tancredidangelo.gestionePrenotazioni.enums.WorkstationType;
import tancredidangelo.gestionePrenotazioni.exceptions.NotFoundException;
import tancredidangelo.gestionePrenotazioni.populateDB.PopulateDatabase;
import tancredidangelo.gestionePrenotazioni.services.BookingService;
import tancredidangelo.gestionePrenotazioni.services.BuildingService;
import tancredidangelo.gestionePrenotazioni.services.UserService;
import tancredidangelo.gestionePrenotazioni.services.WorkstationService;

import java.time.LocalDate;
import java.util.List;

@Component
public class MainRunner implements CommandLineRunner
{

    // dependency injection
    private final PopulateDatabase populateDatabase;
    private final BookingService bookingService;
    private final BuildingService buildingService;
    private final WorkstationService workstationService;
    private final UserService userService;



    // constructor
    public MainRunner(PopulateDatabase populateDatabase, BookingService bookingService, BuildingService buildingService, WorkstationService workstationService, UserService userService) {
        this.populateDatabase = populateDatabase;
        this.bookingService = bookingService;
        this.buildingService = buildingService;
        this.workstationService = workstationService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {

        populateDatabase.populateBuildingsAndWorkstations();
        populateDatabase.populateUsers();

        User user1 = userService.findUserById(5L).orElseThrow(() -> new NotFoundException("User not found"));
        System.out.println(user1);

        User user2 = userService.findUserById(10L).orElseThrow(() -> new NotFoundException("User not found"));
        System.out.println(user2);

        User user3 = userService.findUserById(7L).orElseThrow(() -> new NotFoundException("User not found"));
        System.out.println(user3);

        List<Workstation> wsInRome = workstationService.findWorkstationByCity("Roma");
        System.out.println(wsInRome);

        List<Workstation> wsWithOpenspace = workstationService.findWorkstationByType(WorkstationType.OPENSPACE);
        System.out.println(wsWithOpenspace);

        List<Workstation> wsWithNPeople = workstationService.findWorkstationByNumOfPeople(20);
        System.out.println(wsWithNPeople);

        Workstation workstation1 = workstationService.findWorkstationById(5L).orElseThrow(() -> new NotFoundException("User not found"));

        bookingService.bookWorkstation(user3.getUserId(), workstation1.getWorkstationId(), 10, LocalDate.of(2026, 7, 5));

        System.out.println(buildingService.findAllBuildings());
        System.out.println(buildingService.findByCity("Venezia"));
        System.out.println(buildingService.findByCity("Palermo"));




    }

}
