package com.example.springbootcrudoperations.dto;

import com.example.springbootcrudoperations.model.Address;
import com.example.springbootcrudoperations.model.EmploymentDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class NewPeerDto {
    private long id;
    private String peerName;
    private String email;

    //    private List<AddressDto> addresses;
//    private List<EmploymentDetailsDto> employmentDetailsDtoList;

}
