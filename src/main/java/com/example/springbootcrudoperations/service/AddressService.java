package com.example.springbootcrudoperations.service;

import com.example.springbootcrudoperations.dto.AddressDto;

import java.util.List;

public interface AddressService {
    public AddressDto addAddress(AddressDto addressDto);

    public List<AddressDto> getAddresses();

    public List<AddressDto> getAddressesByPeerIdAndAddressTypeAndAddressDetails(Long peerId, String addressType, String addressDetails);

}



