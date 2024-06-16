package com.hmovie.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmovie.vn.entity.Trailer;

@Repository
public interface TrailerRepository extends JpaRepository<Trailer, Integer>{

}
