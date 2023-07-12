package com.example.springbootcrudoperations.service.impl;

import com.example.springbootcrudoperations.dto.NewPeerDto;
import com.example.springbootcrudoperations.dto.ResponseDto;
import com.example.springbootcrudoperations.exception.UserNotFoundException;
import com.example.springbootcrudoperations.mapper.NewPeerMapper;
import com.example.springbootcrudoperations.model.NewPeer;
import com.example.springbootcrudoperations.repo.NewPeersRepository;
import com.example.springbootcrudoperations.service.CrudService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudServiceImplementation implements CrudService {

    private NewPeerMapper newPeerMapper = Mappers.getMapper(NewPeerMapper.class);
    @Autowired
    private NewPeersRepository newPeersRepository;

    @Override
    public ResponseDto savePeer(NewPeerDto newPeerDto) {
        NewPeer newPeer = newPeerMapper.newPeerDtoToNewPeer(newPeerDto);
        newPeer = newPeersRepository.save(newPeer);
        NewPeerDto newPeerDto1 = newPeerMapper.newPeerToNewPeerDto(newPeer);
        ResponseDto response = ResponseDto.builder()
                .status("SUCCESS")
                .message("Added user to the database.")
                .data(newPeerDto1)
                .build();
        return response;
//        return newPeerDto;
    }

    @Override
    public ResponseDto givePeersList() {
        List<NewPeer> newPeers = (List<NewPeer>) newPeersRepository.findAll();
        List<NewPeerDto> newPeerDtoList = newPeerMapper.newPeerListToNewPeerDtoList(newPeers);
        ResponseDto response = ResponseDto.builder()
                .status("SUCCESS")
                .data(newPeerDtoList)
                .build();
        return response;
    }

    @Override
    public ResponseDto getPeerWithTheId(long id) throws UserNotFoundException {
        NewPeer newPeer = newPeersRepository.findById(id)
                .orElseThrow(() -> UserNotFoundException.badRequest("User not found with id: "+id));
            NewPeerDto newPeerDto = newPeerMapper.newPeerToNewPeerDto(newPeer);
            ResponseDto response = ResponseDto.builder()
                    .status("SUCCESS")
                    .data(newPeerDto)
                    .build();
            return response;
    }

    @Override
    public ResponseDto deletePeerWithId(long id) {
        ResponseDto response = getPeerWithTheId(id);
        newPeersRepository.deleteById(id);
        response.setMessage("Successfully Deleted the user with id: "+id);
        return response;
    }

    @Override
    public ResponseDto updatePeerWithTheId(long id, NewPeerDto newPeerDto) {

        NewPeer newPeer = newPeersRepository.findById(id).orElseThrow(() -> UserNotFoundException.badRequest("User not found with id: "+id));

        newPeer.setPeerName(newPeerDto.getPeerName());
        newPeer.setEmail(newPeerDto.getEmail());

        newPeerDto = newPeerMapper.newPeerToNewPeerDto(newPeer);

        ResponseDto response = ResponseDto.builder()
                .status("SUCCESS")
                .message("Details of User with "+id+" are successfully updated.")
                .data(newPeerDto)
                .build();

        return response;
    }
}
