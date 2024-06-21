package com.hmovie.vn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmovie.vn.entity.Episode;
import com.hmovie.vn.repository.EpisodeRepository;
import com.hmovie.vn.repository.MovieRepository;
import com.hmovie.vn.service.EpisodeService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultEpisodeService implements EpisodeService{
	
	
	@Autowired
	public EpisodeRepository episodeRepository;
	
	@Autowired
	public MovieRepository movieRepository;

	@Override
	@Transactional
	public Episode createEpisode(Episode episode) {
		if(episode == null) {
			return null;
		}
		
		return episodeRepository.saveAndFlush(episode);
		
		
	}

	@Override
	@Transactional
	public Episode updateEpisode(Episode episode) {
		return episodeRepository.save(episode);
	}

	@Override
	@Transactional
	public void deleteEpisode(Integer episodeId) {
		// TODO Auto-generated method stub
		episodeRepository.deleteById(episodeId);
	}

	@Override
	@Transactional
	public List<Episode> createAllEpisode(List<Episode> episodes) {
		if(episodes.isEmpty() || episodes == null) {
			return new ArrayList<Episode>();
		}
		
		return episodeRepository.saveAll(episodes);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Episode getEpisodeBySlug(String slug) {
		
		return episodeRepository.findBySlug(slug).get(0);
	}

}
