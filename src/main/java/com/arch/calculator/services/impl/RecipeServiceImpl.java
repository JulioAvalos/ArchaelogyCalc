package com.arch.calculator.services.impl;

import com.arch.calculator.domain.Recipe;
import com.arch.calculator.repositories.RecipeRepository;
import com.arch.calculator.services.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;

    @Override
    public List<Recipe> listAll() {
        return repository.findAll();
    }

    @Override
    public Recipe add(Recipe obj) {
        return repository.save(obj);
    }

    @Override
    public Recipe modify(Recipe obj) {
        return repository.save(obj);
    }

    @Override
    public Recipe getById(Long id) {
        Optional<Recipe> role = repository.findById(id);
        return role.orElseGet(Recipe::new);
    }

    @Override
    public boolean remove(Long id) {
        repository.deleteById(id);
        return true;
    }
}
