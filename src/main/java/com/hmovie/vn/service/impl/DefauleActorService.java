package com.hmovie.vn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hmovie.vn.entity.Actor;
import com.hmovie.vn.exception.ActorException;
import com.hmovie.vn.repository.ActorRepository;
import com.hmovie.vn.service.ActorService;

@Service
public class DefauleActorService implements ActorService {

	@Autowired
	public ActorRepository actorRepository;

	@Override
	@Transactional
	public Actor createActor(Actor actor) {
		if (actor.getId() != null) {
			if (actorRepository.findById(actor.getId()).orElse(null) != null) {
				throw new ActorException("Actor is already exist!");
			}
		}

		return actorRepository.save(actor);
	}

	@Override
	@Transactional
	public Actor updateActor(Actor actorUpdate) {
		if (actorUpdate.getId() == null) {

			throw new ActorException("Actor is not exist!");
		}
		return actorRepository.save(actorUpdate);
	}

	@Override
	@Transactional
	public void deleteActor(Integer actorId) {
		if (actorId == null) {
			throw new ActorException("Actor id must not be null");
		}
		actorRepository.deleteById(actorId);
	}

}
