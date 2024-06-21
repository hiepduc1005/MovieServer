package com.hmovie.vn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.request.episode.EpisodeCreateRequest;
import com.hmovie.vn.dto.response.EpisodeResponse;
import com.hmovie.vn.entity.Episode;
import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.service.EpisodeService;
import com.hmovie.vn.service.MovieService;
import com.hmovie.vn.service.convert.EpisodeConvert;

@RestController
@RequestMapping("api/v1/episode")
public class EpisodeController {
	
	@Autowired
	public EpisodeService episodeService;
	
	@Autowired
	public EpisodeConvert episodeConvert;
	
	@Autowired
	public MovieService movieService;
	
	@GetMapping("/slug/{slug}")
	public ResponseEntity<EpisodeResponse> getEpisodeBySlug(@PathVariable String slug){
		Episode episode = episodeService.getEpisodeBySlug(slug);
		EpisodeResponse response = episodeConvert.convertToEpisodeResponse(episode);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<String> createEpisode(@RequestBody EpisodeCreateRequest episodeCreateRequest){
	    Episode episode = episodeConvert.episodeCreateRequestConvertToEpisode(episodeCreateRequest);
		Movie movie = movieService.getMovieByImdbId(episodeCreateRequest.getMovieImdbId());
		
		episode.setMovie(movie);
		episode.setSlug(movie.getSlug() + "-" + "episode-" + episodeCreateRequest.getEpisodeNumber());
		episode = episodeService.createEpisode(episode);
		
		return ResponseEntity.ok("Create episode success!");
	}
	
}
