package com.example.sdaApplication.mapper.reservation;

import com.example.sdaApplication.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationMapper {
    public static Reservation resDtoToRes(ReservationDto reservationDTO) {
        if (reservationDTO == null) {
            return null;
        }
        return Reservation.builder()
                .id(reservationDTO.getId())
                .name(reservationDTO.getName())
                //.conferenceRooms(organizationDTO.getConferenceRooms())
                .build();
    }

    public static List<Reservation> resDtoSToResS(List<ReservationDto> reservationDtoS) {
        return reservationDtoS.stream().map(a -> resDtoToRes(a)).collect(Collectors.toList());
    }

    public ReservationDto resToResDto(Reservation reservation) {
        if (reservation == null) {
            return null;
        }
        return ReservationDto.builder()
                .id(reservation.getId())
                .name(reservation.getName())
                //.conferenceRooms(organization.getConferenceRooms())
                .build();
    }

    public List<ReservationDto> resToResDtoS(List<Reservation> reservations) {
        return reservations.stream().map(a -> resToResDto(a)).collect(Collectors.toList());
    }
}
