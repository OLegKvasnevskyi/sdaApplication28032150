package com.example.sdaApplication.service;

import com.example.sdaApplication.mapper.conferenceroom.ConferenceRoomDto;

import java.util.List;

public interface ConferenceRoomService {

    List<ConferenceRoomDto> getAllConferenceRooms();

    ConferenceRoomDto saveConferenceRoom(ConferenceRoomDto conferenceRoomDto);

    ConferenceRoomDto getConferenceRoomById(Integer id);

    ConferenceRoomDto updateConferenceRoom(Integer id, ConferenceRoomDto conferenceRoomDto);

    void deleteConferenceRoomById(Integer id);
}
