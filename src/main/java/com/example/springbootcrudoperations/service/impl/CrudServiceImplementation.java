package com.example.springbootcrudoperations.service.impl;

import com.example.springbootcrudoperations.dto.NewPeerDto;
import com.example.springbootcrudoperations.mapper.NewPeerMapper;
import com.example.springbootcrudoperations.model.NewPeer;
import com.example.springbootcrudoperations.repo.NewPeersRepository;
import com.example.springbootcrudoperations.service.CrudService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudServiceImplementation implements CrudService {

    private NewPeerMapper newPeerMapper = Mappers.getMapper(NewPeerMapper.class);
    @Autowired
    private NewPeersRepository newPeersRepository;

    @Override
    public NewPeerDto savePeer(NewPeerDto newPeerDto) {
        NewPeer peerEntity = newPeerMapper.newPeerDtoToNewPeer(newPeerDto);
        NewPeer newPeer = newPeersRepository.save(peerEntity);
        return newPeerMapper.newPeerToNewPeerDto(newPeer);
//        return newPeerDto;
    }

    @Override
    public List<NewPeerDto> givePeersList() {
        List<NewPeer> newPeers = (List<NewPeer>) newPeersRepository.findAll();
        return newPeerMapper.newPeerListToNewPeerDtoList(newPeers);
    }

    @Override
    public NewPeerDto getPeerWithTheId(long id){

        return newPeerMapper.newPeerToNewPeerDto(newPeersRepository.findById(id).orElse(null));


    }

    @Override
    public void deletePeerWithId(long id) {

        newPeersRepository.deleteById(id);

    }

    @Override
    public NewPeerDto updatePeerWithTheId(long id, NewPeerDto newPeerDto) {

        Optional<NewPeer> newPeerResponse = newPeersRepository.findById(id);
        NewPeer newPeer1 = null;
        if(newPeerResponse.isPresent())
        {
            newPeer1 = newPeerResponse.get();
            newPeer1.setPeerName(newPeerDto.getPeerName());
            newPeer1.setEmail(newPeerDto.getEmail());
        }

        return newPeerMapper.newPeerToNewPeerDto(newPeer1);

    }
}
