package com.example.springbootcrudoperations.service;

import com.example.springbootcrudoperations.dto.NewPeerDto;
import com.example.springbootcrudoperations.dto.ResponseDto;
import com.example.springbootcrudoperations.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CrudService {


    public ResponseDto savePeer(NewPeerDto newPeerDto);

    public ResponseDto givePeersList();

    public ResponseDto getPeerWithTheId(long id) throws UserNotFoundException;

    public ResponseDto deletePeerWithId(long id);

    public ResponseDto updatePeerWithTheId(long id, NewPeerDto newPeerDto);
}
