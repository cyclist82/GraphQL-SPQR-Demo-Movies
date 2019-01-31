# GraphQL-SPQR-Demo-Movies
My little Java Spring Boot Backend for GraphQL Testing. It gives you a Java Backend to maintain a database of Actors and their Movies.

A little Spring Boot Application, good for some testing with GraphQL. 

If you start it you'll have a GraphQL Endpoint on http://localhost:9000/graphql

Here's the GraphQL Schema.

type Mutation {
  addActorToMovie(actorId: String, movieId: String): Movie
  createActor(name: String): Actor
  }
type Query {
  findActorByID(id: String): Actor
  allMovies: [Movie]
  allActors: [Actor]
  findMovieByTitleContains(title: String): [Movie]
  }
  
type Actor {
  id: String
  movies: [Movie]
  name: String
  }
  
type Movie {
  actors: [Actor]
  description: String
  director: String
  id: String
  title: String
  }
