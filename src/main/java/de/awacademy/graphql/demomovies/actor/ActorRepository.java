package de.awacademy.graphql.demomovies.actor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, String> {

	List<Actor> findByNameContainsIgnoreCaseOrderByNameAsc(String nameContains);
}
