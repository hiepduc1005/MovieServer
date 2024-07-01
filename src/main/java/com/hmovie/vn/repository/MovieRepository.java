package com.hmovie.vn.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hmovie.vn.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    void deleteByImdbId(String imdbId);

    Movie findByImdbId(String imdbId);

    List<Movie> findByActorsId(Integer actorsId);

    List<Movie> findByDirectorsId(Integer directorsId);

    List<Movie> findByGenresId(Integer genreId);

    List<Movie> findByTrailerId(Integer trailerId);
    
    Movie findBySlug(String slug);
    
    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:query% OR m.description LIKE %:query%")
    Page<Movie> findMovieByQueryWithPaginate(String query, Pageable pageable);
    
 
}
