package com.hmovie.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hmovie.vn.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
