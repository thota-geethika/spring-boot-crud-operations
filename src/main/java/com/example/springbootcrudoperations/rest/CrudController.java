package com.example.springbootcrudoperations.rest;

import com.example.springbootcrudoperations.dto.NewPeerDto;
import com.example.springbootcrudoperations.dto.ResponseDto;
import com.example.springbootcrudoperations.exception.UserNotFoundException;
import com.example.springbootcrudoperations.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CrudController {

    @Autowired
    private CrudService crudService;


    @PostMapping("/addPeer")
    public NewPeerDto addAPeer(@RequestBody NewPeerDto newPeerDto) {
        System.out.println(newPeerDto);
        NewPeerDto newPeerDto1 = crudService.savePeer(newPeerDto);
        log.info("newPeerDto1: ",newPeerDto1);
        return newPeerDto1;
    }

    @GetMapping("/peers")
    public ResponseEntity<?> getPeers() {
        List<NewPeerDto> response = crudService.givePeersList();
        log.info("Response : {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/peers/{id}")
    public ResponseEntity<?> getPeerWithAGivenId(@PathVariable long id) throws UserNotFoundException {
        ResponseDto response = ResponseDto.builder()
                .status("SUCCESS")
                .data(crudService.getPeerWithTheId(id))
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/peers/{id}")
    public void deletePeerWithId(@PathVariable long id) {
        crudService.deletePeerWithId(id);
    }

    @PutMapping("/peers/{id}")
    public NewPeerDto updatePeerWithId(@PathVariable long id, @RequestBody NewPeerDto newPeerDto) {
        return crudService.updatePeerWithTheId(id, newPeerDto);
    }
}
