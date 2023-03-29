package com.example.sdaApplication.mapper.conferenceroom;

import com.example.sdaApplication.model.ConferenceRoom;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConferenceRoomMapper {

    public static ConferenceRoom roomDtoToRoom(ConferenceRoomDto conferenceRoomDTO) {
        if (conferenceRoomDTO == null) {
            return null;
        }
        return ConferenceRoom.builder()
                .id(conferenceRoomDTO.getId())
                .name(conferenceRoomDTO.getName())
                .identifier(conferenceRoomDTO.getIdentifier())
                .availability(conferenceRoomDTO.getAvailability())
                .numberOfSeats(conferenceRoomDTO.getNumberOfSeats())
 //               .organization(conferenceRoomDTO.getOrganization())
                .build();
    }

    public static List<ConferenceRoom> roomDtoSToRoomS(List<ConferenceRoomDto> conferenceRoomDtoS) {
        return conferenceRoomDtoS.stream().map(a -> roomDtoToRoom(a)).collect(Collectors.toList());
    }

    public ConferenceRoomDto roomToRoomDto(ConferenceRoom conferenceRoom) {
        if (conferenceRoom == null) {
            return null;
        }
        return ConferenceRoomDto.builder()
                .id(conferenceRoom.getId())
                .name(conferenceRoom.getName())
                .identifier(conferenceRoom.getIdentifier())
                .availability(conferenceRoom.getAvailability())
                .numberOfSeats(conferenceRoom.getNumberOfSeats())
               .organization(conferenceRoom.getOrganization())
                .build();
    }

    public List<ConferenceRoomDto> roomSToRoomDtoS(List<ConferenceRoom> conferenceRoomS) {
        return conferenceRoomS.stream().map(a -> roomToRoomDto(a)).collect(Collectors.toList());
    }
}
