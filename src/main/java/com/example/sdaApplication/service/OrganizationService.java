package com.example.sdaApplication.service;


import com.example.sdaApplication.mapper.organization.OrganizationDto;

import java.util.List;

public interface OrganizationService {
    List<OrganizationDto> getAllOrganizations();

    OrganizationDto saveOrganization(OrganizationDto organizationDto);

    OrganizationDto getOrganizationById(Integer id);

    OrganizationDto updateOrganization(Integer id, OrganizationDto organizationDto);

    void deleteOrganizationById(Integer id);
}
