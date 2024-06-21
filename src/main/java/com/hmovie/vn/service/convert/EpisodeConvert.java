package com.hmovie.vn.service.convert;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hmovie.vn.dto.request.episode.EpisodeCreateRequest;
import com.hmovie.vn.dto.response.EpisodeResponse;
import com.hmovie.vn.entity.Episode;

@Service
public class EpisodeConvert {
	
	public Episode episodeCreateRequestConvertToEpisode(EpisodeCreateRequest episodeCreateRequest) {
		Episode episode = new Episode();
		episode.setEpisodeNumber(episodeCreateRequest.getEpisodeNumber());
		episode.setEpisodeUrl(episodeCreateRequest.getEpisodeUrl());
		episode.setTotalEpisode(episodeCreateRequest.getTotalEpisode());
		
		return episode;
	}
	
	public EpisodeResponse convertToEpisodeResponse(Episode episode) {
		EpisodeResponse episodeResponse = 
				new EpisodeResponse(
						episode.getId(),
						episode.getTotalEpisode(),
						episode.getSlug(),
						episode.getEpisodeNumber(),
						episode.getEpisodeUrl()
						);
		return episodeResponse;
	}
	
	public List<EpisodeResponse> convertToEpisodeResponse(List<Episode> episodes) {
		List<EpisodeResponse> episodeResponse = new ArrayList<EpisodeResponse>();
		
		for(Episode episode : episodes ) {
			episodeResponse.add(convertToEpisodeResponse(episode));
		}
		return episodeResponse;
	}
}
