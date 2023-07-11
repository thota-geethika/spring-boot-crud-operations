package com.example.springbootcrudoperations.service;

import com.example.springbootcrudoperations.dto.NewPeerDto;
import com.example.springbootcrudoperations.exception.UserNotFoundException;

import java.util.List;


public interface CrudService {


    public NewPeerDto savePeer(NewPeerDto newPeerDto);

    public List<NewPeerDto> givePeersList();

    public NewPeerDto getPeerWithTheId(long id) throws UserNotFoundException;

    public void deletePeerWithId(long id);

    public NewPeerDto updatePeerWithTheId(long id, NewPeerDto newPeerDto);
}
