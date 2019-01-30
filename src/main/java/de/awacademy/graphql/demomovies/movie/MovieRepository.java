package de.awacademy.graphql.demomovies.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {

	List<Movie> findByTitleContainsIgnoreCase(String title);
}
