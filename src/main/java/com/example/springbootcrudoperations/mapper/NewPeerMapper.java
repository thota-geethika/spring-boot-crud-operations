package com.example.springbootcrudoperations.mapper;

import com.example.springbootcrudoperations.dto.NewPeerDto;
import com.example.springbootcrudoperations.model.NewPeer;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NewPeerMapper {

    NewPeerDto newPeerToNewPeerDto(NewPeer newPeer);

    NewPeer newPeerDtoToNewPeer(NewPeerDto newPeerDto);

    List<NewPeerDto> newPeerListToNewPeerDtoList(List<NewPeer> newPeers);

    List<NewPeer> newPeerDtoListToNewPeerList(List<NewPeerDto> newPeerDtos);


}
