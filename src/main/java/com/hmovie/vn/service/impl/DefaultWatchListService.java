package com.hmovie.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmovie.vn.entity.WatchList;
import com.hmovie.vn.repository.WatchListRepository;
import com.hmovie.vn.service.WatchListService;

@Service
public class DefaultWatchListService implements WatchListService {

    @Autowired
    public WatchListRepository watchListRepository;

    @Override
    @Transactional
    public WatchList createWatchList() {
        WatchList watchList = new WatchList();
        return watchListRepository.save(watchList);
    }

}
