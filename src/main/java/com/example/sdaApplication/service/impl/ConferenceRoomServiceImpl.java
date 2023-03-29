package com.example.sdaApplication.service.impl;

import com.example.sdaApplication.exception.ResourceNotFoundException;
import com.example.sdaApplication.mapper.conferenceroom.ConferenceRoomDto;
import com.example.sdaApplication.mapper.conferenceroom.ConferenceRoomMapper;
import com.example.sdaApplication.model.ConferenceRoom;
import com.example.sdaApplication.repository.ConferenceRoomRepository;
import com.example.sdaApplication.service.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ConferenceRoomServiceImpl implements ConferenceRoomService {
    private final ConferenceRoomRepository conferenceRoomRepository;
    private final ConferenceRoomMapper conferenceRoomMapper;


    @Autowired
    public ConferenceRoomServiceImpl(ConferenceRoomRepository conferenceRoomRepository,
                                     ConferenceRoomMapper conferenceRoomMapper) {
        this.conferenceRoomRepository = conferenceRoomRepository;
        this.conferenceRoomMapper = conferenceRoomMapper;
    }

    @Override
    public List<ConferenceRoomDto> getAllConferenceRooms() {
        return conferenceRoomMapper.roomSToRoomDtoS(conferenceRoomRepository.findAll());
    }

    @Override
    public ConferenceRoomDto saveConferenceRoom(ConferenceRoomDto conferenceRoomDto) {
        ConferenceRoom conferenceRoom = conferenceRoomMapper.roomDtoToRoom(conferenceRoomDto);
        ConferenceRoom saveConferenceRoom = conferenceRoomRepository.save(conferenceRoom);
        return conferenceRoomMapper.roomToRoomDto(saveConferenceRoom);
    }

    @Override
    public ConferenceRoomDto getConferenceRoomById(Integer id) {
        return conferenceRoomRepository
                .findById(id)
                .map(conferenceRoomMapper::roomToRoomDto)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public ConferenceRoomDto updateConferenceRoom(Integer id, ConferenceRoomDto conferenceRoomDto) {
        ConferenceRoom conferenceRoomUpdateById = conferenceRoomRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        ConferenceRoom conferenceRoom = conferenceRoomMapper.roomDtoToRoom(conferenceRoomDto);
        conferenceRoomUpdateById.setName(conferenceRoom.getName());
        conferenceRoomUpdateById.setIdentifier(conferenceRoom.getIdentifier());
        conferenceRoomUpdateById.setAvailability(conferenceRoom.getAvailability());
        conferenceRoomUpdateById.setNumberOfSeats(conferenceRoom.getNumberOfSeats());
        conferenceRoomUpdateById.setOrganization(conferenceRoom.getOrganization());
        return conferenceRoomMapper.roomToRoomDto(conferenceRoomRepository.save(conferenceRoomUpdateById));
    }

    @Override
    public void deleteConferenceRoomById(Integer id) {
        ConferenceRoom conferenceRoom = conferenceRoomRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        conferenceRoomRepository.delete(conferenceRoom);
    }
}
