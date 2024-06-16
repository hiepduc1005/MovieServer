package com.hmovie.vn.service;

import com.hmovie.vn.entity.Actor;

public interface ActorService {

	Actor createActor(Actor actor);

	Actor updateActor(Actor actorUpdate);

	void deleteActor(Integer actorId);

}
