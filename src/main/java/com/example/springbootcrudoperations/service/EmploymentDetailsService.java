package com.example.springbootcrudoperations.service;

import com.example.springbootcrudoperations.dto.EmploymentDetailsDto;

import java.util.List;

public interface EmploymentDetailsService {
    EmploymentDetailsDto addDetail(EmploymentDetailsDto employmentDetailsDto);

    List<EmploymentDetailsDto> getDetails();
}
