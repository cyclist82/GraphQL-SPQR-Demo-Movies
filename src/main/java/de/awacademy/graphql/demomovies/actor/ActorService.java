package de.awacademy.graphql.demomovies.actor;

import graphql.GraphQLException;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@GraphQLApi
public class ActorService {

	private ActorRepository actorRepository;

	public ActorService(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}

	@GraphQLQuery
	public List<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@GraphQLQuery
	public Actor findActorByID(String id) {
		return actorRepository.findById(id).orElseThrow(() -> new GraphQLException("Schauspieler konnte nicht gefunden werden."));
	}

	@GraphQLMutation
	public Actor createActor(String name) {
		return actorRepository.save(new Actor(name));
	}

}
