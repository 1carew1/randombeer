package com.colmcarew.randombeer.data;

import com.colmcarew.randombeer.model.Beer;
import com.colmcarew.randombeer.model.Brewery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by colmcarew on 13/07/2017.
 */
public interface BreweryRepository extends JpaRepository<Brewery, Long> {
}
