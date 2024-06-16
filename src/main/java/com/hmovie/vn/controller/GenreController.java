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

import com.hmovie.vn.dto.request.Genre.GenreCreateRequest;
import com.hmovie.vn.dto.request.Genre.GenreUpdateRequest;
import com.hmovie.vn.dto.response.GenreResponse;
import com.hmovie.vn.entity.Genre;
import com.hmovie.vn.service.GenreService;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {

    @Autowired
    public GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreResponse> createGenre(@RequestBody GenreCreateRequest genreCreateRequest) {
        Genre genre = new Genre();
        genre.setName(genreCreateRequest.getName());

        genre = genreService.createGenre(genre);

        GenreResponse genreResponse = new GenreResponse();
        genreResponse.setId(genre.getId());
        genreResponse.setName(genre.getName());

        return ResponseEntity.ok(genreResponse);
    }

    @PutMapping
    public ResponseEntity<GenreResponse> updateGenre(@RequestBody GenreUpdateRequest genreUpdateRequest) {
        Genre genre = new Genre();
        genre.setName(genreUpdateRequest.getName());
        genre.setId(genreUpdateRequest.getId());

        genre = genreService.updateGenre(genre);

        GenreResponse genreResponse = new GenreResponse();
        genreResponse.setId(genre.getId());
        genreResponse.setName(genre.getName());

        return ResponseEntity.ok(genreResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable Integer id) {
        genreService.deleteGenre(id);

        return ResponseEntity.ok("Delete genre with id: " + id + " success!");
    }
}
