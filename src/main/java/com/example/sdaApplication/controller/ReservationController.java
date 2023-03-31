package com.example.sdaApplication.controller;


import com.example.sdaApplication.mapper.reservation.ReservationDto;
import com.example.sdaApplication.model.Reservation;
import com.example.sdaApplication.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;


    //@PageableDefault(sort = {"name"}, direction = Sort.Direction.ASC)
    @GetMapping("/reservations")
    public String listReservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

    @GetMapping("/reservations/new")
    public String createReservationForm(Model model) {
        Reservation reservation = new Reservation();
        model.addAttribute("reservation", reservation);
        return "create_reservation";
    }

    @PostMapping("/reservations")
    public String saveReservation(@ModelAttribute("reservation") ReservationDto reservationDto) {
        reservationService.saveReservation(reservationDto);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/edit/{id}")
    public String editReservationForm(@PathVariable Integer id, Model model) {
        model.addAttribute("reservation", reservationService.getReservationById(id));
        return "edit_reservation";
    }

    @GetMapping("/reservations/{id}")
    public String deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservationById(id);
        return "redirect:/reservations";
    }

    @PostMapping("/reservations/{id}")
    public String updateReservation(@PathVariable Integer id,
                                    @ModelAttribute("reservation") ReservationDto reservationDto, Model model) {
        ReservationDto existingReservation = reservationService.getReservationById(id);
        existingReservation.setId(id);
        existingReservation.setName(reservationDto.getName());
        reservationService.updateReservation(id, existingReservation);
        return "redirect:/reservations";
    }

}
