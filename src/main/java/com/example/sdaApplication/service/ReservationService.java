package com.example.sdaApplication.service;

import com.example.sdaApplication.mapper.reservation.ReservationDto;

import java.util.List;

public interface ReservationService {
    List<ReservationDto> getAllReservations();

    ReservationDto saveReservation(ReservationDto reservationDto);

    ReservationDto getReservationById(Integer id);

    ReservationDto updateReservation(Integer id, ReservationDto reservationDto);

    void deleteReservationById(Integer id);
}
