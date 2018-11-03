package com.stackroute.distributor.repository;

import com.stackroute.distributor.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {
}
