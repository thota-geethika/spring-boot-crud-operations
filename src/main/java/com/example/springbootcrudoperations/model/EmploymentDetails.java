package com.example.springbootcrudoperations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "employment_details")
@ToString
public class EmploymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "company-name")
    private String companyName;
    @Column(name = "year")
    private String year;
    @ManyToOne
    @JoinColumn(name = "peer-id", nullable = false,updatable = false)
    private NewPeer newPeer;
}
