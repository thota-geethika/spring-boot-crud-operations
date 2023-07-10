package com.example.springbootcrudoperations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Table(name = "new_peers")
@Entity
@Getter
@Setter
@ToString
public class NewPeer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "peer-name", nullable = false)
    private String peerName;
    @Column(name = "email-id")
    private String email;

//    @OneToMany(mappedBy = "newPeer",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Address> addresses;
//
//    @OneToMany(mappedBy = "newPeer", cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<EmploymentDetails> employmentDetailsList;

}
