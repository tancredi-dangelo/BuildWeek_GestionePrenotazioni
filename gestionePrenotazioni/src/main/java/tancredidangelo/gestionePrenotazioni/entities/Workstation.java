package tancredidangelo.gestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tancredidangelo.gestionePrenotazioni.enums.WorkstationStatus;
import tancredidangelo.gestionePrenotazioni.enums.WorkstationType;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "workstations")
public class Workstation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long workstationId;

    @Column(name = "workstation_description")
    private String description;

    @Column(name = "max_number_of_people", nullable = false)
    private String maxNumOfPeople;

    @ManyToOne
    @JoinColumn(name = "building_name")
    private Building building;

    @Column(name = "type")
    private WorkstationType workstationType;

    @Enumerated(EnumType.STRING)
    @Column(name = "workstation_status", nullable = false)
    private WorkstationStatus workstationStatus;

    @OneToMany(mappedBy = "workstation", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    List<Booking> bookings;



    /// constructor

    public Workstation(String description, String maxNumOfPeople, Building building, WorkstationType workstationType, WorkstationStatus workstationStatus) {
        this.description = description;
        this.maxNumOfPeople = maxNumOfPeople;
        this.building = building;
        this.workstationType = workstationType;
        this.workstationStatus = workstationStatus;
    }



    /// to string

    @Override
    public String toString() {
        return "Workstation {" +
                "workstationId = " + workstationId +
                ", description = '" + description + '\'' +
                ", maxNumOfPeople = '" + maxNumOfPeople + '\'' +
                ", building = " + building +
                ", workstationType = " + workstationType +
                ", workstationStatus = " + workstationStatus +
                ", bookings = " + bookings +
                '}';
    }
}
