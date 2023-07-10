package com.example.springbootcrudoperations.rest;

import com.example.springbootcrudoperations.dto.EmploymentDetailsDto;
import com.example.springbootcrudoperations.model.EmploymentDetails;
import com.example.springbootcrudoperations.service.EmploymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employmentDetails")
public class EmploymentDetailsController {

    @Autowired
    private EmploymentDetailsService employmentDetailsService;

    @PostMapping("/detail")
    public EmploymentDetailsDto addEmploymentDetail(@RequestBody EmploymentDetailsDto employmentDetailsDto){
        EmploymentDetailsDto detailsEntityDto = employmentDetailsService.addDetail(employmentDetailsDto);
        return detailsEntityDto;

    }

    @GetMapping("/getDetails")
    public List<EmploymentDetailsDto> getEmploymentDetails(){
        List<EmploymentDetailsDto> employmentDetailsDtoList = employmentDetailsService.getDetails();
        return employmentDetailsDtoList;
    }
}
