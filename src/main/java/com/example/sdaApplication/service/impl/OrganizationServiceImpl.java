package com.example.sdaApplication.service.impl;

import com.example.sdaApplication.exception.ResourceNotFoundException;
import com.example.sdaApplication.mapper.organization.OrganizationDto;
import com.example.sdaApplication.mapper.organization.OrganizationMapper;
import com.example.sdaApplication.model.Organization;
import com.example.sdaApplication.repository.OrganizationRepository;
import com.example.sdaApplication.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
    }

    @Override
    public List<OrganizationDto> getAllOrganizations() {
        return organizationMapper.orgToOrgDtoS(organizationRepository.findAll());
    }

    @Override
    public OrganizationDto getOrganizationById(Integer id) {
        return organizationRepository
                .findById(id)
                .map(organizationMapper::orgToOrgDto)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
    }

    @Override
    public OrganizationDto updateOrganization(Integer id, OrganizationDto organizationDto) {
        Organization organizationUpdateById = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
        Organization organization = organizationMapper.orgDtoToOrg(organizationDto);
        organizationUpdateById.setName(organization.getName());
        return organizationMapper.orgToOrgDto(organizationRepository.save(organizationUpdateById));
    }

    @Override
    public void deleteOrganizationById(Integer id) {
        Organization organization = organizationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id));
        organizationRepository.delete(organization);
    }


    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = Organization.builder()
                .id(organizationDto.getId())
                .name(organizationDto.getName())
                .build();
        Organization saveOrganization = organizationRepository.save(organization);
        return organizationMapper.orgToOrgDto(saveOrganization);
    }
}







