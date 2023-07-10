package com.example.springbootcrudoperations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "address_details")
@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "address-type")
    private String addressType;

    @Column(name = "address-details")
    private String addressDetails;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "peer-id", insertable = true, updatable = false)  //insertable = true is default tho
    private NewPeer newPeer;
}
