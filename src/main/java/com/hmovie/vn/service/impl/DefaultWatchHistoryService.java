package com.hmovie.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmovie.vn.entity.Movie;
import com.hmovie.vn.entity.User;
import com.hmovie.vn.entity.WatchHistory;
import com.hmovie.vn.repository.WatchHistoryRepository;
import com.hmovie.vn.service.WatchHistoryService;

@Service
public class DefaultWatchHistoryService implements WatchHistoryService {

	@Autowired
	public WatchHistoryRepository watchHistoryRepository;
	
	@Override
	@Transactional
	public WatchHistory createWatchHistory(WatchHistory watchHistory) {
		if(watchHistory.getId() != null) {
			throw new RuntimeException("Watch already exist!");
		}
		return watchHistoryRepository.save(watchHistory);
	}

	@Override
	@Transactional
	public WatchHistory update(WatchHistory watchHistory) {
		if(watchHistory.getId() == null) {
			throw new RuntimeException("Watch doesnt already exist!");
		}
		return watchHistoryRepository.save(watchHistory);
	}

	@Override
	@Transactional
	public void delete(Integer watchHistoryId) {
		if(watchHistoryId == null || watchHistoryId < 0) {
			throw new RuntimeException("Id must not null and must be positive!");
		}
		
		watchHistoryRepository.deleteById(watchHistoryId);
	}

	@Override
	@Transactional(readOnly = true)
	public WatchHistory findByMovieAndUser(Movie movie, User user) {
		
		return watchHistoryRepository.findByMovieAndUser(movie, user);
	}

}