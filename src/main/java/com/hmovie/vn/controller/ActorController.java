package com.hmovie.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hmovie.vn.dto.request.Actor.ActorCreateRequest;
import com.hmovie.vn.dto.request.Actor.ActorUpdateRequest;
import com.hmovie.vn.dto.response.ActorResponse;
import com.hmovie.vn.entity.Actor;
import com.hmovie.vn.service.ActorService;


@RestController
@RequestMapping("api/v1/actor")
public class ActorController {

    @Autowired
    public ActorService actorService;

    @PostMapping
    public ResponseEntity<ActorResponse> createActor(@RequestBody ActorCreateRequest actorCreateRequest) {
        Actor actor = new Actor();
        actor.setName(actorCreateRequest.getName());

        actor = actorService.createActor(actor);

        ActorResponse actorResponse = new ActorResponse();
        actorResponse.setId(actor.getId());
        actorResponse.setName(actor.getName());

        return ResponseEntity.ok(actorResponse);
    }

    @PutMapping
    public ResponseEntity<ActorResponse> updateActor(@RequestBody ActorUpdateRequest actorUpdateRequest) {
        Actor actor = new Actor();
        actor.setName(actorUpdateRequest.getName());
        actor.setId(actorUpdateRequest.getId());

        actor = actorService.updateActor(actor);

        ActorResponse actorResponse = new ActorResponse();
        actorResponse.setId(actor.getId());
        actorResponse.setName(actor.getName());

        return ResponseEntity.ok(actorResponse);
    }

    @DeleteMapping("/{actorId}")
    public ResponseEntity<String> deleteActor(@PathVariable Integer actorId) {
        actorService.deleteActor(actorId);

        return ResponseEntity.ok("Delete actor with id " + actorId + " success!");
    }

}
