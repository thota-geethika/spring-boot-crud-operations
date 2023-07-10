package com.example.springbootcrudoperations.repo;

import com.example.springbootcrudoperations.model.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AddressSearchDao {
    private final EntityManager em; //we are injecting the entity manager through RequiredArgsConstructor


    public List<Address> findAllBySimpleQuery(Long peerId, String addressType, String addressDetails){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Address> criteriaQuery = criteriaBuilder.createQuery(Address.class);

        //select * from Address;
        Root<Address> root = criteriaQuery.from(Address.class);

        //prepare where clause
        // where peerId like
        Predicate peerIdPredicate = criteriaBuilder.
                equal(root.get("newPeer").get("id"),peerId);

        Predicate addressTypePredicate = criteriaBuilder.
                equal(root.get("addressType"),addressType);

        Predicate addressDetailsPredicate = criteriaBuilder.
                equal(root.get("addressDetails"),addressDetails);

        Predicate peerIdOrAddressTypeOrAddressDetailsPredicate = criteriaBuilder.and(
                peerIdPredicate,
                addressTypePredicate,
                addressDetailsPredicate
        );

        criteriaQuery.where(peerIdOrAddressTypeOrAddressDetailsPredicate);
        TypedQuery<Address> query = em.createQuery(criteriaQuery);
        return query.getResultList();




    }
}
