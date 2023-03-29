package com.example.sdaApplication.controller;

import com.example.sdaApplication.mapper.organization.OrganizationDto;
import com.example.sdaApplication.model.Organization;
import com.example.sdaApplication.service.OrganizationService;
import lombok.AllArgsConstructor;
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
//@RequestMapping("/")
public class OrganizationController {

    private final OrganizationService organizationService;


    //@GetMapping("/organizations")
    //@ResponseStatus("/organizations")
    //@RequestMapping(value = "/organizations", method = RequestMethod.GET)

    @GetMapping("/home")
    public String home() {

        return "home";
    }
    //@PageableDefault(sort = {"name"}, direction = Sort.Direction.ASC)
    @GetMapping("/organizations")
    public String listOrganizations(Model model) {
        model.addAttribute("organizations", organizationService.getAllOrganizations());
        System.out.println(organizationService.getAllOrganizations().toString());
        return "organizations";
    }

    @GetMapping("/organizations/new")
    public String createOrganizationForm(Model model) {
        Organization organization = new Organization();
        model.addAttribute("organization", organization);
        return "create_organization";
    }

    @PostMapping("/organizations")
    public String saveOrganization(@ModelAttribute("organization") OrganizationDto organizationDto) {
        organizationService.saveOrganization(organizationDto);
        return "redirect:/organizations";
    }

    @GetMapping("/organizations/edit/{id}")
    public String editOrganizationForm(@PathVariable Integer id, Model model) {
        model.addAttribute("organization", organizationService.getOrganizationById(id));
        return "edit_organization";
    }

    @GetMapping("/organizations/{id}")
    public String deleteOrganization(@PathVariable Integer id) {
        organizationService.deleteOrganizationById(id);
        return "redirect:/organizations";
    }

    @PostMapping("/organizations/{id}")
    public String updateOrganization(@PathVariable Integer id,
                                     @ModelAttribute("organization") OrganizationDto organizationDto, Model model) {
        OrganizationDto existingOrganization = organizationService.getOrganizationById(id);
        existingOrganization.setId(id);
        existingOrganization.setName(organizationDto.getName());
        organizationService.updateOrganization(id, existingOrganization);
        return "redirect:/organizations";
    }

}
