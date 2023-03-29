package com.example.sdaApplication.model;


import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Entity
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organization")
public class Organization {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "org_id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 20, message = "Invalid first name!(2-20 characters)")
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "name", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<ConferenceRoom> conferenceRooms;

    public Organization(String name) {
        this.name = name;
    }

    public Organization(String name, List<ConferenceRoom> conferenceRooms) {
        this.name = name;
        this.conferenceRooms = conferenceRooms;
    }


}
