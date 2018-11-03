package com.stackroute.distributor.repository;

import com.stackroute.distributor.domain.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City,String> {
}
