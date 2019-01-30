package de.awacademy.graphql.demomovies.actor;

import de.awacademy.graphql.demomovies.movie.Movie;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actor {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid",
			strategy = "uuid2")
	private String id;
	private String name;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "actors")
	private List<Movie> movies = new ArrayList<>();

	public Actor() {
	}

	public Actor(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
