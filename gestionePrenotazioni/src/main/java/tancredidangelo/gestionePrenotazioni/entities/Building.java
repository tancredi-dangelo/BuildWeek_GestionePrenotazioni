package tancredidangelo.gestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long buildingId;

    @Column(name = "building_name")
    private String buildingName;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "building")
    List<Workstation> workstations;



    // constructor

    public Building(String buildingName, String city, String address) {
        this.buildingName = buildingName;
        this.city = city;
        this.address = address;
    }


    // to string

    @Override
    public String toString() {
        return "\nBuilding {" +
                "buildingId = " + buildingId +
                " buildingName = '" + buildingName + '\'' +
                ", city = '" + city + '\'' +
                ", address = '" + address + '\'' +
                ", workstations = " + workstations +
                '}';
    }
}
