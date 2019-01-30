package de.awacademy.graphql.demomovies;

import de.awacademy.graphql.demomovies.actor.Actor;
import de.awacademy.graphql.demomovies.actor.ActorRepository;
import de.awacademy.graphql.demomovies.movie.Movie;
import de.awacademy.graphql.demomovies.movie.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemomoviesApplication {

	private ActorRepository actorRepository;
	private MovieRepository movieRepository;

	public DemomoviesApplication(ActorRepository actorRepository, MovieRepository movieRepository) {
		this.actorRepository = actorRepository;
		this.movieRepository = movieRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemomoviesApplication.class, args);
	}

	@PostConstruct
	private void fillFakeDB() {
		Actor arnold = new Actor("Arnold Schwarzenegger");
		arnold = actorRepository.save(arnold);
		Movie terminator2 = new Movie("Terminator 2", "The War against the Machines developed by AWAcademy is on", "James Cameron");
		terminator2.getActors().add(arnold);
		movieRepository.save(terminator2);
		Actor bruce = new Actor("Bruce Willis");
		bruce = actorRepository.save(bruce);
		Actor john = new Actor("John Travolta");
		john = actorRepository.save(john);
		Actor uma = new Actor("Uma Thurman");
		uma = actorRepository.save(uma);
		Actor samuelL = new Actor("Samuel L. Jackson");
		samuelL = actorRepository.save(samuelL);
		Movie pulp = new Movie("Pulp Fictin", "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption. ", "Quentin Tarantino");
		pulp.getActors().add(bruce);
		pulp.getActors().add(john);
		pulp.getActors().add(uma);
		pulp.getActors().add(samuelL);
		movieRepository.save(pulp);
		Movie dieHard = new Movie("Stirb Langsam 3", "John McClane and a Harlem store owner are targeted by German terrorist Simon Gruber in New York City, where he plans to rob the Federal Reserve Building.", "John McTiernan");
		dieHard.getActors().add(bruce);
		dieHard.getActors().add(samuelL);
		movieRepository.save(dieHard);
	}

}

