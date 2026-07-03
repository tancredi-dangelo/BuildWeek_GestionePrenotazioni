package tancredidangelo.gestionePrenotazioni.populateDB;

import org.springframework.stereotype.Component;
import tancredidangelo.gestionePrenotazioni.entities.Building;
import tancredidangelo.gestionePrenotazioni.entities.User;
import tancredidangelo.gestionePrenotazioni.entities.Workstation;
import tancredidangelo.gestionePrenotazioni.enums.WorkstationType;
import tancredidangelo.gestionePrenotazioni.services.BuildingService;
import tancredidangelo.gestionePrenotazioni.services.UserService;
import tancredidangelo.gestionePrenotazioni.services.WorkstationService;

import java.util.List;

@Component
public class PopulateDatabase {

    // dependency injection
    private final UserService userService;
    private final WorkstationService workstationService;
    private final BuildingService buildingService;

    // constructor
    public PopulateDatabase( UserService userService, BuildingService buildingService, WorkstationService workstationService) {
        this.userService = userService;
        this.workstationService = workstationService;
        this.buildingService = buildingService;
    }


    // questi li ho chiesti all'AI per fare prima!!!

    public void populateUsers() {

        List<User> users = List.of(
                new User("Gianluigi", "Buffon", "gigibuffon@gmail.com"),
                new User("Fabio", "Grosso", "fabiogrosso@gmail.com"),
                new User("Fabio", "Cannavaro", "fabiocanna@gmail.com"),
                new User("Andrea", "Pirlo", "andreapirlo@gmail.com"),
                new User("Francesco", "Totti", "francescototti@gmail.com"),
                new User("Alessandro", "Del Piero", "alexdelpiero@gmail.com"),
                new User("Daniele", "De Rossi", "danielederossi@gmail.com"),
                new User("Gennaro", "Gattuso", "rinogattuso@gmail.com"),
                new User("Marco", "Materazzi", "marcomaterazzi@gmail.com"),
                new User("Filippo", "Inzaghi", "pippoinzaghi@gmail.com")
        );

        users.forEach(userService::saveUser);

    }


    public void populateBuildingsAndWorkstations() {

        List<Building> buildings = List.of(
                new Building("Palazzo Daje", "Palermo", "Via Maccheronai 18"),
                new Building("Edificio 8", "Ankara", "Via Yay 234"),
                new Building("Studio 23", "Palermo", "Via Chiavettieri 1"),
                new Building("Torre Azzurra", "Milano", "Corso Buenos Aires 45"),
                new Building("Villa Scudetto", "Torino", "Via della Juve 10"),
                new Building("Palazzo Olimpico", "Roma", "Viale dello Stadio 7"),
                new Building("Centro Direzionale Sud", "Napoli", "Via Partenope 88"),
                new Building("Loft Riviera", "Genova", "Via del Porto 3"),
                new Building("Edificio Nord", "Bologna", "Via delle Torri 22"),
                new Building("Spazio Laguna", "Venezia", "Fondamenta Nuove 5")
        );

        buildings.forEach(buildingService::saveBuilding);

        List<Workstation> workstations = List.of(
                new Workstation("Spazio Averna", 30, buildings.get(0), WorkstationType.ROOM),
                new Workstation("Spazio Franco", 30, buildings.get(0), WorkstationType.ROOM),
                new Workstation("Sala Riunioni A", 15, buildings.get(0), WorkstationType.OPENSPACE),

                new Workstation("Spazio Lolli", 50, buildings.get(1), WorkstationType.OPENSPACE),
                new Workstation("Ufficio Direzionale", 8, buildings.get(1), WorkstationType.ROOM),
                new Workstation("Open Space Est", 40, buildings.get(1), WorkstationType.OPENSPACE),

                new Workstation("Sala Conferenze", 20, buildings.get(2), WorkstationType.ROOM),
                new Workstation("Postazione Creativa", 12, buildings.get(2), WorkstationType.OPENSPACE),
                new Workstation("Sala Formazione", 25, buildings.get(2), WorkstationType.ROOM),

                new Workstation("Open Space Nord", 45, buildings.get(3), WorkstationType.OPENSPACE),
                new Workstation("Sala Meeting Milano", 10, buildings.get(3), WorkstationType.ROOM),
                new Workstation("Postazione Coworking", 35, buildings.get(3), WorkstationType.OPENSPACE),

                new Workstation("Sala Bianconera", 14, buildings.get(4), WorkstationType.ROOM),
                new Workstation("Open Space Scudetto", 38, buildings.get(4), WorkstationType.OPENSPACE),
                new Workstation("Sala Strategia", 6, buildings.get(4), WorkstationType.ROOM),

                new Workstation("Sala Capitolina", 22, buildings.get(5), WorkstationType.ROOM),
                new Workstation("Open Space Colosseo", 42, buildings.get(5), WorkstationType.OPENSPACE),
                new Workstation("Postazione Executive", 5, buildings.get(5), WorkstationType.ROOM),

                new Workstation("Sala Vesuvio", 18, buildings.get(6), WorkstationType.ROOM),
                new Workstation("Open Space Golfo", 33, buildings.get(6), WorkstationType.OPENSPACE),
                new Workstation("Sala Riunioni Sud", 11, buildings.get(6), WorkstationType.ROOM),

                new Workstation("Sala Lanterna", 16, buildings.get(7), WorkstationType.ROOM),
                new Workstation("Open Space Porto", 28, buildings.get(7), WorkstationType.OPENSPACE),
                new Workstation("Postazione Marina", 9, buildings.get(7), WorkstationType.ROOM),

                new Workstation("Sala Torri", 20, buildings.get(8), WorkstationType.ROOM),
                new Workstation("Open Space Portici", 36, buildings.get(8), WorkstationType.OPENSPACE),
                new Workstation("Sala Emiliana", 13, buildings.get(8), WorkstationType.ROOM),

                new Workstation("Sala Laguna", 17, buildings.get(9), WorkstationType.ROOM),
                new Workstation("Open Space Canal Grande", 30, buildings.get(9), WorkstationType.OPENSPACE),
                new Workstation("Postazione Rialto", 7, buildings.get(9), WorkstationType.ROOM)
        );

        workstations.forEach(workstationService::saveWorkstation);
    }

}

