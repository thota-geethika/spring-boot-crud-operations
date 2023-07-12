//package com.example.springbootcrudoperations.mapper;
//
//import com.example.springbootcrudoperations.dto.ResponseDto;
//import com.example.springbootcrudoperations.model.NewPeer;
//import org.mapstruct.*;
//
//@Mapper(componentModel = "spring",
//        unmappedTargetPolicy = ReportingPolicy.IGNORE,
//        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//public interface NewPeerMapperTwo {
//
//    @Mapping(source = "id", target = "data.id")
//    @Mapping(source = "peerName", target = "data.peerName")
//    @Mapping(source = "email", target = "data.email")
//    ResponseDto NewPeerToResponseDto(NewPeer newPeer);
//}
//
