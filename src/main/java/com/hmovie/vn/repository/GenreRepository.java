package com.hmovie.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmovie.vn.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
