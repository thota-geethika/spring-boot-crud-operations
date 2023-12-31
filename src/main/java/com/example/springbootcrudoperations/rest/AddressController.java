package com.example.springbootcrudoperations.rest;

import com.example.springbootcrudoperations.dto.AddressDto;
import com.example.springbootcrudoperations.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/addAddress")
    public AddressDto addAddressOfAParticularType(@RequestBody AddressDto addressDto){
        return addressService.addAddress(addressDto);
    }


    @GetMapping("/allAddresses")
    public List<AddressDto> getAllTheAddresses(){
        return addressService.getAddresses();
    }

    @GetMapping("/addresses")
    public List<AddressDto> getAllAddressesWithTheConditions(@RequestParam(required = true) Long peerId, @RequestParam(required = false) String addressType, @RequestParam(required = false) String addressDetails){

        List<AddressDto> addressDtoList;
        addressDtoList = addressService.getAddressesByPeerIdAndAddressTypeAndAddressDetails(peerId,addressType,addressDetails);
        return addressDtoList;
    }
}
