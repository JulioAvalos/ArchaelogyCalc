package com.arch.calculator.repositories;

import com.arch.calculator.domain.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository
        extends MongoRepository<Recipe, Long> {
}
