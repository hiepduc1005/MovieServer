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

import com.hmovie.vn.dto.request.Trailer.TrailerCreateRequest;
import com.hmovie.vn.dto.request.Trailer.TrailerUpdateRequest;
import com.hmovie.vn.dto.response.TrailerResponse;
import com.hmovie.vn.entity.Trailer;
import com.hmovie.vn.service.TrailerService;

@RestController
@RequestMapping("api/v1/trailer")
public class TrailerController {

    @Autowired
    public TrailerService trailerService;

    @PostMapping
    public ResponseEntity<TrailerResponse> createTrailer(@RequestBody TrailerCreateRequest trailerCreateRequest) {
        Trailer trailer = new Trailer();
        trailer.setTrailerUrl(trailerCreateRequest.getTrailerUrl());

        trailer = trailerService.createTrailer(trailer);

        TrailerResponse trailerResponse = new TrailerResponse(
                trailer.getId(),
                trailer.getTrailerUrl());

        return ResponseEntity.ok(trailerResponse);
    }

    @PutMapping
    public ResponseEntity<TrailerResponse> updateTrailer(@RequestBody TrailerUpdateRequest trailerUpdateRequest) {
        Trailer trailer = new Trailer();
        trailer.setId(trailerUpdateRequest.getId());
        trailer.setTrailerUrl(trailerUpdateRequest.getTrailerUrl());

        trailer = trailerService.updateTrailer(trailer);

        TrailerResponse trailerResponse = new TrailerResponse(
                trailer.getId(),
                trailer.getTrailerUrl());

        return ResponseEntity.ok(trailerResponse);
    }

    @DeleteMapping("/{trailerId}")
    public ResponseEntity<String> deleteTrailer(@PathVariable Integer trailerId) {
        trailerService.deleteTrailer(trailerId);

        return ResponseEntity.ok("Delete trailer with id: " + trailerId + " success!");
    }

}
