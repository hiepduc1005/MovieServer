package com.hmovie.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.entity.WatchHistory;

@Repository
public interface WatchHistoryRepository extends JpaRepository<WatchHistory, Integer>{
	
	WatchHistory findByMovie(Movie movie);
}
