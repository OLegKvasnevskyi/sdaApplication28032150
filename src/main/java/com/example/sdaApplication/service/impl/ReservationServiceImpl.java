package com.example.sdaApplication.service.impl;

import com.example.sdaApplication.exception.ResourceNotFoundException;
import com.example.sdaApplication.mapper.reservation.ReservationDto;
import com.example.sdaApplication.mapper.reservation.ReservationMapper;
import com.example.sdaApplication.model.Reservation;
import com.example.sdaApplication.repository.ReservationRepository;
import com.example.sdaApplication.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        return reservationMapper.resToResDtoS(reservationRepository.findAll());
    }

    @Override
    public ReservationDto getReservationById(Integer id) {
        return reservationRepository
                .findById(id)
                .map(reservationMapper::resToResDto)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
    }

    @Override
    public ReservationDto updateReservation(Integer id, ReservationDto reservationDto) {
        Reservation reservationUpdateById = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
        Reservation reservation = reservationMapper.resDtoToRes(reservationDto);
        reservationUpdateById.setName(reservation.getName());
        return reservationMapper.resToResDto(reservationRepository.save(reservationUpdateById));
    }

    @Override
    public void deleteReservationById(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
        reservationRepository.delete(reservation);
    }


    @Override
    public ReservationDto saveReservation(ReservationDto reservationDto) {
        Reservation reservation = Reservation.builder()
                .id(reservationDto.getId())
                .name(reservationDto.getName())
                .build();
        Reservation saveReservation = reservationRepository.save(reservation);
        return reservationMapper.resToResDto(saveReservation);
    }

}






