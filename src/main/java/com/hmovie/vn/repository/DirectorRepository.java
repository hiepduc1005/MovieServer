package com.hmovie.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmovie.vn.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer>{

}
