package com.divv.examendivv.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.divv.examendivv.models.Comic;

public interface ComicRepository extends MongoRepository<Comic, String>, MarvelRepository
{
}
