package com.hmovie.vn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmovie.vn.entity.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Integer>{
	
	
	List<Episode> findBySlug(String slug);
}
