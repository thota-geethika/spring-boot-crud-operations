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
    public ResponseEntity<?> addAPeer(@RequestBody NewPeerDto newPeerDto) {
        System.out.println(newPeerDto);
        ResponseDto response = crudService.savePeer(newPeerDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/peers")
    public ResponseEntity<?> getPeers() {
        ResponseDto response = crudService.givePeersList();
        log.info("Response : {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/peers/{id}")
    public ResponseEntity<?> getPeerWithAGivenId(@PathVariable long id) throws UserNotFoundException {
        ResponseDto response = crudService.getPeerWithTheId(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/peers/{id}")
    public ResponseEntity<?> deletePeerWithId(@PathVariable long id) {
        ResponseDto response = crudService.deletePeerWithId(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/peers/{id}")
    public ResponseEntity<?> updatePeerWithId(@PathVariable long id, @RequestBody NewPeerDto newPeerDto) {
        ResponseDto response = crudService.updatePeerWithTheId(id, newPeerDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
