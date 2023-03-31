package com.example.sdaApplication.controller;


import com.example.sdaApplication.mapper.conferenceroom.ConferenceRoomDto;
import com.example.sdaApplication.model.ConferenceRoom;
import com.example.sdaApplication.model.Organization;
import com.example.sdaApplication.service.ConferenceRoomService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@AllArgsConstructor
@Data
public class ConferenceRoomController {
    private ConferenceRoomService conferenceRoomService;


    @GetMapping("/conferencerooms")
    public String listConferenceRooms(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Model model) {

        model.addAttribute("conferencerooms", conferenceRoomService.getAllConferenceRooms());


        return "/conferencerooms";
    }

    @PostMapping("/conferencerooms")
    public String saveConferenceRoom(@ModelAttribute("conferenceroom") ConferenceRoomDto conferenceRoomDto) {
        conferenceRoomService.saveConferenceRoom(conferenceRoomDto);
        return "redirect:/conferencerooms";
    }

    @GetMapping("/conferencerooms/new")
    public String createConferenceRoomForm(Model model) {
        ConferenceRoom conferenceRoom = new ConferenceRoom();
        model.addAttribute("conferenceroom", conferenceRoom);
        return "create_conferenceroom";
    }

    @GetMapping("/conferencerooms/edit/{id}")
    public String editConferenceRoomForm(@PathVariable Integer id, Model model) {
        model.addAttribute("conferenceroom", conferenceRoomService.getConferenceRoomById(id));
        model.addAttribute("conferenceroom.identifier", "manager");
        return "edit_conferenceroom";
    }

    @GetMapping("/conferencerooms/reservation/{id}")
    public String reservationConferenceRoomForm(@PathVariable Integer id, ConferenceRoom conferenceRoom, Organization organization, Model model) {
        model.addAttribute("conferenceroom", conferenceRoomService.getConferenceRoomById(id));
        ConferenceRoomDto confRoomDtoTemp = conferenceRoomService.getConferenceRoomById(id);
/*
        .setPostHeader("Avengers");

        List<Organization> allComments = new ArrayList<>();
        comment1.setText("Tony Stark was great!");
        comment2.setText("No, Iron Man was the best!");
        comment3.setText("Have you heard about Tor?");

        allComments.add(comment1);
        allComments.add(comment2);
        allComments.add(confRoomDtoTemp);

        post.setComments(allComments);

 */

        return "reservation_conferenceroom";
    }

    @PostMapping("/conferencerooms/{id}")
    public String updateConferenceRoom(@PathVariable Integer id,
                                       @ModelAttribute("conferenceroom") ConferenceRoom conferenceRoom, Model model) {
        ConferenceRoomDto existingConferenceRoom = conferenceRoomService.getConferenceRoomById(id);
        existingConferenceRoom.setId(id);
        existingConferenceRoom.setName(conferenceRoom.getName());
        existingConferenceRoom.setIdentifier(conferenceRoom.getIdentifier());
        existingConferenceRoom.setAvailability(conferenceRoom.getAvailability());
        existingConferenceRoom.setNumberOfSeats(conferenceRoom.getNumberOfSeats());
        conferenceRoomService.updateConferenceRoom(id, existingConferenceRoom);
        return "redirect:/conferencerooms";
    }

    @GetMapping("/conferencerooms/{id}")
    public String deleteConferenceRoom(@PathVariable Integer id) {
        conferenceRoomService.deleteConferenceRoomById(id);
        return "redirect:/conferencerooms";
    }


}
