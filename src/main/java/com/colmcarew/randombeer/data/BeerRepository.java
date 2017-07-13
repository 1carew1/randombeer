package com.colmcarew.randombeer.data;

import com.colmcarew.randombeer.model.Beer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by colmcarew on 13/07/2017.
 */
public interface BeerRepository extends CrudRepository<Beer, Long> {}
