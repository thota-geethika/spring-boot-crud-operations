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

        List<Predicate> predicates = new ArrayList<>();

        //select * from Address;
        Root<Address> root = criteriaQuery.from(Address.class);

        if(peerId != null){
            Predicate peerIdPredicate = criteriaBuilder.
                    equal(root.get("newPeer").get("id"),peerId);
            predicates.add(peerIdPredicate);
        }

        if(addressType != null){
            Predicate addressTypePredicate = criteriaBuilder.
                    equal(root.get("addressType"),addressType);
            predicates.add(addressTypePredicate);
        }

        if(addressDetails != null){
            Predicate addressDetailsPredicate = criteriaBuilder.
                    equal(root.get("addressDetails"),addressDetails);
            predicates.add(addressDetailsPredicate);
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Address> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
