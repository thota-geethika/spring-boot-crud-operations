package com.example.springbootcrudoperations.rest;

import com.example.springbootcrudoperations.dto.NewPeerDto;
import com.example.springbootcrudoperations.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        return crudService.savePeer(newPeerDto);
    }

    @GetMapping("/peers")
    public ResponseEntity<?> getPeers() {
        List<NewPeerDto> response = crudService.givePeersList();
        log.info("Response : {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/peers/{id}")
    public NewPeerDto getPeerWithAGivenId(@PathVariable long id) {
        return crudService.getPeerWithTheId(id);
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
