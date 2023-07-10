package com.example.springbootcrudoperations.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmploymentDetailsDto {

    private long id;
    private String companyName;
    private String year;
    private long peerId;
}
