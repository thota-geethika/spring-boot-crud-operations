package com.example.springbootcrudoperations.mapper;

import com.example.springbootcrudoperations.dto.AddressDto;
import com.example.springbootcrudoperations.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AddressMapper {

    @Mapping(source = "newPeer.id", target="peerId")
    AddressDto addressToAddressDto(Address address);

    @Mapping(source = "peerId",target = "newPeer.id")
    Address addressDtoToAddress(AddressDto addressDto);

    List<AddressDto> addressListToAddressDtoList(List<Address> addresses);

    List<Address> addressDtoListToaddressList(List<AddressDto> addressDtos);
}

