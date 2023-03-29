package com.example.sdaApplication.mapper.conferenceroom;

import com.example.sdaApplication.model.AvailabilityEnum;
import com.example.sdaApplication.model.IdentifierEnum;
import com.example.sdaApplication.model.Organization;
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
@Table(name = "conferenceroom_dto")
public class ConferenceRoomDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conferenceroom_id", nullable = false)
    private Integer id;
    @NotBlank(message = "Conference room's name is mandatory")
    @Size(min = 2, max = 20, message = "Invalid first name!(2-20 characters)")
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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Organization organization;


    public ConferenceRoomDto(String name) {
        this.name = name;
    }


}




