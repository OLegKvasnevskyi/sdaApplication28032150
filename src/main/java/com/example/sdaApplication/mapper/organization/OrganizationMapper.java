package com.example.sdaApplication.mapper.organization;


import com.example.sdaApplication.model.Organization;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class OrganizationMapper {
    public static Organization orgDtoToOrg(OrganizationDto organizationDTO) {
        if (organizationDTO == null) {
            return null;
        }
        return Organization.builder()
                .id(organizationDTO.getId())
                .name(organizationDTO.getName())
                //.conferenceRooms(organizationDTO.getConferenceRooms())
                .build();
    }

    public static List<Organization> orgDtoSToOrgS(List<OrganizationDto> organizationDtoS) {
        return organizationDtoS.stream().map(a -> orgDtoToOrg(a)).collect(Collectors.toList());
    }

    public OrganizationDto orgToOrgDto(Organization organization) {
        if (organization == null) {
            return null;
        }
        return OrganizationDto.builder()
                .id(organization.getId())
                .name(organization.getName())
                //.conferenceRooms(organization.getConferenceRooms())
                .build();
    }

    public List<OrganizationDto> orgToOrgDtoS(List<Organization> organizations) {
        return organizations.stream().map(a -> orgToOrgDto(a)).collect(Collectors.toList());
    }
}
