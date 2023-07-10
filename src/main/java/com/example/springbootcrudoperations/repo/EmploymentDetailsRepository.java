package com.example.springbootcrudoperations.repo;

import com.example.springbootcrudoperations.model.EmploymentDetails;
import org.springframework.data.repository.CrudRepository;

public interface EmploymentDetailsRepository extends CrudRepository<EmploymentDetails,Long> {

}
