package com.example.springbootcrudoperations.repo;

import com.example.springbootcrudoperations.model.NewPeer;
import org.springframework.data.repository.CrudRepository;

public interface NewPeersRepository extends CrudRepository<NewPeer, Long> {
}
