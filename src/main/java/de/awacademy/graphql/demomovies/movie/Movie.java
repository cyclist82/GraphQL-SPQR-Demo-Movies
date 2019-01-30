package de.awacademy.graphql.demomovies.movie;

import de.awacademy.graphql.demomovies.actor.Actor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid",
			strategy = "uuid2")
	private String id;
	private String title;
	private String description;
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Actor> actors = new ArrayList<>();
	private String director;

	public Movie() {
	}

	public Movie(String title, String description, String director) {
		this.title = title;
		this.description = description;
		this.director = director;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
}
