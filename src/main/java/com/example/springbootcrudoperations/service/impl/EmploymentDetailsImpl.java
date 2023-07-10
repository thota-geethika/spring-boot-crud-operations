package com.example.springbootcrudoperations.service.impl;

import com.example.springbootcrudoperations.dto.EmploymentDetailsDto;
import com.example.springbootcrudoperations.mapper.EmploymentDetailsMapper;
import com.example.springbootcrudoperations.model.EmploymentDetails;
import com.example.springbootcrudoperations.repo.EmploymentDetailsRepository;
import com.example.springbootcrudoperations.service.EmploymentDetailsService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentDetailsImpl implements EmploymentDetailsService {

    @Autowired
    private EmploymentDetailsRepository employmentDetailsRepository;

    private EmploymentDetailsMapper employmentDetailsMapper = Mappers.getMapper(EmploymentDetailsMapper.class);
    @Override
    public EmploymentDetailsDto addDetail(EmploymentDetailsDto employmentDetailsDto) {

        EmploymentDetails employmentDetails =  employmentDetailsMapper.employmentDetailsDtoToEmploymentDetails(employmentDetailsDto);
        employmentDetails = employmentDetailsRepository.save(employmentDetails);
        EmploymentDetailsDto employmentDetailsDto1 = employmentDetailsMapper.employmentDetailsToEmploymentDetailsDto(employmentDetails);
        return employmentDetailsDto1;
    }

    @Override
    public List<EmploymentDetailsDto> getDetails() {
        List<EmploymentDetails> employmentDetailsList = (List<EmploymentDetails>) employmentDetailsRepository.findAll();
        List<EmploymentDetailsDto> employmentDetailsDtoList = employmentDetailsMapper.employmentDetailsListToEmploymentDetailsDtoList(employmentDetailsList);
        return employmentDetailsDtoList;
    }
}
