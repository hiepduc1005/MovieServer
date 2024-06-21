package com.hmovie.vn.service;

import java.util.List;

import com.hmovie.vn.entity.Episode;

public interface EpisodeService {
	Episode createEpisode(Episode episode);
	
	List<Episode> createAllEpisode(List<Episode> episodes);
	
	Episode updateEpisode(Episode episode);
	
	void deleteEpisode(Integer episodeId);
	
	Episode getEpisodeBySlug(String slug);
}
