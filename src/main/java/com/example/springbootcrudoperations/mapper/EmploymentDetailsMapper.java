package com.example.springbootcrudoperations.mapper;

import com.example.springbootcrudoperations.dto.EmploymentDetailsDto;
import com.example.springbootcrudoperations.model.EmploymentDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmploymentDetailsMapper {

    @Mapping(source = "newPeer.id", target = "peerId")
    EmploymentDetailsDto employmentDetailsToEmploymentDetailsDto(EmploymentDetails employmentDetails);
    @Mapping(source = "peerId", target = "newPeer.id")
    EmploymentDetails employmentDetailsDtoToEmploymentDetails(EmploymentDetailsDto employmentDetailsDto);

    List<EmploymentDetailsDto> employmentDetailsListToEmploymentDetailsDtoList(List<EmploymentDetails> employmentDetailsList);
}
