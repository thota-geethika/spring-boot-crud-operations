package com.example.springbootcrudoperations.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    private long id;
    private String addressType;
    private String addressDetails;
    private Long peerId;
}
