package com.example.sdaApplication;


import com.example.sdaApplication.model.*;
import com.example.sdaApplication.repository.ConferenceRoomRepository;
import com.example.sdaApplication.repository.OrganizationRepository;
import com.example.sdaApplication.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
class AppInitializer {

    private final OrganizationRepository organizationRepository;
    private final ConferenceRoomRepository conferenceRoomRepository;
    private final ReservationRepository reservationRepository;


    @Autowired
    AppInitializer(OrganizationRepository organizationRepository,
                   ConferenceRoomRepository conferenceRoomRepository, ReservationRepository reservationRepository) {
        this.organizationRepository = organizationRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
        this.reservationRepository = reservationRepository;
    }


    @PostConstruct
    void init() {

        organizationRepository.save(new Organization("Meta"));
        organizationRepository.save(new Organization("Amazon"));
        organizationRepository.save(new Organization("Google"));
        conferenceRoomRepository.save(new ConferenceRoom("Google Hall", IdentifierEnum.MEETING_ROOM, AvailabilityEnum.FREE, 10, null));
        conferenceRoomRepository.save(new ConferenceRoom("Amazon Hall", IdentifierEnum.MEETING_ROOM, AvailabilityEnum.FREE, 15, null));
        conferenceRoomRepository.save(new ConferenceRoom("Meta Hall", IdentifierEnum.CONFERENCE_ROOM, AvailabilityEnum.FREE, 50, null));

        reservationRepository.save(new Reservation(new Date(), new Date(), "MetaReservation", null));
        reservationRepository.save(new Reservation(new Date(), new Date(), "MetaReservation", null));
        reservationRepository.save(new Reservation(new Date(), new Date(), "MetaReservation", null));

/*
        Organization organization = new Organization("Google");
        ConferenceRoom conferenceRoom = new ConferenceRoom(
                "Google Hall",
                IdentifierEnum.MEETING_ROOM,
                AvailabilityEnum.FREE,
                10,
                null);

        conferenceRoom.setOrganization(organization);

        conferenceRoomRepository.save(conferenceRoom);
*/

    }


}