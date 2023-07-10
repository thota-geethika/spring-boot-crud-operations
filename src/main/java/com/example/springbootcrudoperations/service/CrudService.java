package com.example.springbootcrudoperations.service;

import com.example.springbootcrudoperations.dto.NewPeerDto;

import java.util.List;


public interface CrudService {


    public NewPeerDto savePeer(NewPeerDto newPeerDto);

    public List<NewPeerDto> givePeersList();

    public NewPeerDto getPeerWithTheId(long id);

    public void deletePeerWithId(long id);

    public NewPeerDto updatePeerWithTheId(long id, NewPeerDto newPeerDto);
}
