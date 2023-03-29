package com.example.sdaApplication;


import com.example.sdaApplication.model.AvailabilityEnum;
import com.example.sdaApplication.model.ConferenceRoom;
import com.example.sdaApplication.model.IdentifierEnum;
import com.example.sdaApplication.model.Organization;
import com.example.sdaApplication.repository.ConferenceRoomRepository;
import com.example.sdaApplication.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class AppInitializer {

    private final OrganizationRepository organizationRepository;
    private final ConferenceRoomRepository conferenceRoomRepository;


    @Autowired
    AppInitializer(OrganizationRepository organizationRepository,
                   ConferenceRoomRepository conferenceRoomRepository) {
        this.organizationRepository = organizationRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
    }


    @PostConstruct
    void init() {

        organizationRepository.save(new Organization("Google" ,null));
        //organizationRepository.save(new Organization("Amazon"));
//        organizationRepository.save(new Organization("Meta"));


        conferenceRoomRepository.save(new ConferenceRoom("Google Hall", IdentifierEnum.MEETING_ROOM, AvailabilityEnum.FREE, 10, null));
        conferenceRoomRepository.save(new ConferenceRoom("Google Hall", IdentifierEnum.MEETING_ROOM, AvailabilityEnum.FREE, 15, null));
        conferenceRoomRepository.save(new ConferenceRoom("Google Hall", IdentifierEnum.CONFERENCE_ROOM, AvailabilityEnum.FREE, 50, null));


    }


}