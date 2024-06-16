package com.hmovie.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmovie.vn.entity.WatchList;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, Integer>{

}
