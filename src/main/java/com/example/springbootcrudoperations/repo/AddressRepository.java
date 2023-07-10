package com.example.springbootcrudoperations.repo;

import com.example.springbootcrudoperations.model.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

    @Query(value = "select a from Address a where a.newPeer.id=:peerId")
    public List<Address> getByPeerId(Long peerId);

    @Query(value = "select a from Address a where a.newPeer.id=:peerId and a.addressType=:addressType")
    public List<Address> getByPeerIdAndAddressType(Long peerId, String addressType);

    @Query(value = "select a from Address a where a.newPeer.id=:peerId and a.addressType=:addressType and a.addressDetails=:addressDetails")
    public List<Address> getByPeerIdAndAddressTypeAndAddressDetails(Long peerId, String addressType, String addressDetails);

    @Query(value = "select a from Address a where a.newPeer.id=:peerId and a.addressDetails=:addressDetails")
    public List<Address> getByPeerIdAndAddressDetails(Long peerId, String addressDetails);
}



