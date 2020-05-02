package com.arch.calculator.services.impl;

import com.arch.calculator.domain.Material;
import com.arch.calculator.repositories.MaterialRepository;
import com.arch.calculator.services.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository repository;

    @Override
    public List<Material> listAll() {
        return repository.findAll();
    }

    @Override
    public Material add(Material obj) {
        return repository.save(obj);
    }

    @Override
    public Material modify(Material obj) {
        return repository.save(obj);
    }

    @Override
    public Material getById(Long id) {
        Optional<Material> role = repository.findById(id);
        return role.orElseGet(Material::new);
    }

    @Override
    public boolean remove(Long id) {
        repository.deleteById(id);
        return true;
    }
}
