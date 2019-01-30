package de.awacademy.graphql.demomovies.movie;

import de.awacademy.graphql.demomovies.actor.Actor;
import de.awacademy.graphql.demomovies.actor.ActorRepository;
import graphql.GraphQLException;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotation.GraphQLApi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@GraphQLApi
public class MovieService {

	private MovieRepository movieRepository;
	private ActorRepository actorRepository;

	public MovieService(MovieRepository movieRepository, ActorRepository actorRepository) {
		this.movieRepository = movieRepository;
		this.actorRepository = actorRepository;
	}

	@GraphQLQuery
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@GraphQLQuery
	public List<Movie> findMovieByTitleContains(String title) {
		return movieRepository.findByTitleContainsIgnoreCase(title);
	}

	@GraphQLMutation
	public Movie addActorToMovie(String movieId, String actorId) {
		Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new GraphQLException("Film wurde nicht gefunden"));
		Actor actor = actorRepository.findById(actorId).orElseThrow(() -> new GraphQLException("Schauspieler wurde nicht gefunden"));
		if(movie.getActors().contains(actor)){
			throw new GraphQLException("Schauspieler spielt bereits in diesem Film mit");
		}
		movie.getActors().add(actor);
		return movieRepository.save(movie);
	}
}
