package com.hmovie.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmovie.vn.entity.Trailer;
import com.hmovie.vn.repository.TrailerRepository;
import com.hmovie.vn.service.TrailerService;

@Service
public class DefaultTrailerService implements TrailerService {

    @Autowired
    public TrailerRepository trailerRepository;

    @Override
    public Trailer createTrailer(Trailer trailer) {
        if (trailer.getId() != null) {
            throw new RuntimeException("Trailer already exist");
        }
        return trailerRepository.save(trailer);
    }

    @Override
    public void deleteTrailer(Integer trailerId) {
        if (trailerId == null || trailerId <= 0) {
            throw new RuntimeException("Trailer id must not be null and must be positive");
        }
        trailerRepository.deleteById(trailerId);
    }

    @Override
    public Trailer updateTrailer(Trailer trailer) {
        if (trailer.getId() == null || trailer.getId() <= 0) {
            throw new RuntimeException("Trailer not exist");
        }
        return trailerRepository.save(trailer);
    }

}
