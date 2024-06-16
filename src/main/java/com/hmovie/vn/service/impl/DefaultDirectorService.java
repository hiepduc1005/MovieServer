package com.hmovie.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmovie.vn.entity.Director;
import com.hmovie.vn.exception.ActorException;
import com.hmovie.vn.exception.DirectorException;
import com.hmovie.vn.repository.DirectorRepository;
import com.hmovie.vn.service.DirectorService;

@Service
public class DefaultDirectorService implements DirectorService {

    @Autowired
    public DirectorRepository directorRepository;

    @Override
    @Transactional
    public Director createDirector(Director director) {
        if (director.getId() != null) {
            if (directorRepository.findById(director.getId()).orElse(null) != null) {
                throw new DirectorException("Director is already exist!");
            }
        }

        return directorRepository.save(director);
    }

    @Override
    @Transactional
    public void deleteDirector(Integer directorId) {
        if (directorId == null) {
            throw new ActorException("Director id must not be null");
        }
        directorRepository.deleteById(directorId);
    }

    @Override
    @Transactional
    public Director updateDirector(Director directorUpdate) {
        if (directorUpdate.getId() == null) {

            throw new DirectorException("Director is not exist!");
        }
        return directorRepository.save(directorUpdate);
    }

}
