package com.hmovie.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.request.Director.DirectorCreateRequest;
import com.hmovie.vn.dto.request.Director.DirectorUpdateRequest;
import com.hmovie.vn.dto.response.DirectorResponse;
import com.hmovie.vn.entity.Director;
import com.hmovie.vn.service.DirectorService;

@RestController
@RequestMapping("api/v1/director")
public class DirectorController {

    @Autowired
    public DirectorService directorService;

    @PostMapping
    public ResponseEntity<DirectorResponse> createDirector(@RequestBody DirectorCreateRequest directorCreateRequest) {
        Director director = new Director();
        director.setName(directorCreateRequest.getName());

        director = directorService.createDirector(director);

        DirectorResponse directorResponse = new DirectorResponse();
        directorResponse.setId(director.getId());
        directorResponse.setName(director.getName());

        return ResponseEntity.ok(directorResponse);
    }

    @PutMapping
    public ResponseEntity<DirectorResponse> updateDirector(@RequestBody DirectorUpdateRequest directorUpdateRequest) {
        Director director = new Director();
        director.setName(directorUpdateRequest.getName());
        director.setId(directorUpdateRequest.getId());

        director = directorService.createDirector(director);

        DirectorResponse directorResponse = new DirectorResponse();
        directorResponse.setId(director.getId());
        directorResponse.setName(director.getName());

        return ResponseEntity.ok(directorResponse);
    }

    @DeleteMapping("/{directorId}")
    public ResponseEntity<String> deleteDirector(@PathVariable Integer directorId) {
        directorService.deleteDirector(directorId);

        return ResponseEntity.ok("Delete director with id " + directorId + " success!");
    }

}
