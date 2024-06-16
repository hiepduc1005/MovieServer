package com.hmovie.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmovie.vn.entity.Genre;
import com.hmovie.vn.repository.GenreRepository;
import com.hmovie.vn.service.GenreService;

@Service
public class DefaultGenreService implements GenreService {

    @Autowired
    public GenreRepository genreRepository;

    @Override
    @Transactional
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    @Transactional
    public void deleteGenre(Integer genreId) {
        genreRepository.deleteById(genreId);
    }

    @Override
    @Transactional
    public Genre updateGenre(Genre genreUpdate) {
        return genreRepository.save(genreUpdate);
    }

}
