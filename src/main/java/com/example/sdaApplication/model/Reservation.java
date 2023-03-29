package com.example.sdaApplication.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id", nullable = false)
    private Integer id;
    private Date startOfBooking;
    private Date endOfBooking;
    private String name;
    private String conferenceRoomBooked;
    private UUID uniqueId;

/*
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "reserv_room",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "conferenceroom_id")
    )
    private List<ConferenceRoom> reservations;
*/

    public Reservation(String name) {
        this.name = name;
    }


}
