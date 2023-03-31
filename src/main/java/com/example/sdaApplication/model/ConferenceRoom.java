package com.example.sdaApplication.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "conferenceroom")
public class ConferenceRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conf_id", nullable = false)
    private Integer id;
    @NotBlank(message = "Conference room's name is mandatory")
    @Size(min = 2, max = 20)
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "identifier")
    @Enumerated(EnumType.STRING)
    private IdentifierEnum identifier;
    @Column(name = "availability")
    @Enumerated(EnumType.STRING)
    private AvailabilityEnum availability;
    @Column(name = "number_of_seats", nullable = false)
    private Integer numberOfSeats;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "org_id")
    private Organization organization;

    /*
                @ManyToMany(mappedBy = "reservations")
                private List<Reservation> reservations;

                @OneToMany(mappedBy = "conferenceRoom", cascade = CascadeType.ALL, orphanRemoval = true)
                private List<Equipment> equipments;

            public ConferenceRoom(String name) {
                this.name = name;
            }
        */
    public ConferenceRoom(String name,
                          IdentifierEnum identifier,
                          AvailabilityEnum availability,
                          Integer numberOfSeats,
                          Organization organization) {
        this.name = name;
        this.identifier = identifier;
        this.availability = availability;
        this.numberOfSeats = numberOfSeats;
        this.organization = organization;

    }


    public ConferenceRoom(String name,
                          IdentifierEnum identifier,
                          AvailabilityEnum availability,
                          Integer numberOfSeats) {
        this.name = name;
        this.identifier = identifier;
        this.availability = availability;
        this.numberOfSeats = numberOfSeats;
    }
}