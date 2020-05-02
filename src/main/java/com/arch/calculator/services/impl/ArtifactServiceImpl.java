package com.arch.calculator.services.impl;

import com.arch.calculator.domain.Artifact;
import com.arch.calculator.repositories.ArtifactRepository;
import com.arch.calculator.services.ArtifactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArtifactServiceImpl implements ArtifactService {

    private final ArtifactRepository repository;

    @Override
    public List<Artifact> listAll() {
        return repository.findAll();
    }

    @Override
    public Artifact add(Artifact obj) {
        return repository.save(obj);
    }

    @Override
    public Artifact modify(Artifact obj) {
        return repository.save(obj);
    }

    @Override
    public Artifact getById(Long id) {
        Optional<Artifact> role = repository.findById(id);
        return role.orElseGet(Artifact::new);
    }

    @Override
    public boolean remove(Long id) {
        repository.deleteById(id);
        return true;
    }
}
