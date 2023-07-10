package com.example.springbootcrudoperations.service.impl;

import com.example.springbootcrudoperations.dto.AddressDto;
import com.example.springbootcrudoperations.mapper.AddressMapper;
import com.example.springbootcrudoperations.model.Address;
import com.example.springbootcrudoperations.repo.AddressRepository;
import com.example.springbootcrudoperations.repo.AddressSearchDao;
import com.example.springbootcrudoperations.repo.NewPeersRepository;
import com.example.springbootcrudoperations.service.AddressService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressSearchDao addressSearchDao;

    @Autowired
    private NewPeersRepository peersRepository;
    private AddressMapper addressMapper = Mappers.getMapper(AddressMapper.class);
    @Override
    public AddressDto addAddress(AddressDto addressDto) {
        Address entity = addressMapper.addressDtoToAddress(addressDto);
        Address address = addressRepository.save(entity);
        return addressMapper.addressToAddressDto(address);
    }

    @Override
    public List<AddressDto> getAddresses() {
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        for (Address i:
             addresses) {
            System.out.println(i);
        }
        return addressMapper.addressListToAddressDtoList(addresses);
    }


    @Override
    public List<AddressDto> getAddressesByPeerIdAndAddressTypeAndAddressDetails(Long peerId, String addressType, String addressDetails) {
        List<Address> addressList = addressSearchDao.findAllBySimpleQuery(peerId,addressType,addressDetails);
        List<AddressDto> addressDtoList = addressMapper.addressListToAddressDtoList(addressList);
        return addressDtoList;
    }

}
