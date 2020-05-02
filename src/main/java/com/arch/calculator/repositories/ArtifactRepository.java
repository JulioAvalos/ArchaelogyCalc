package com.arch.calculator.repositories;

import com.arch.calculator.domain.Artifact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtifactRepository extends MongoRepository<Artifact, Long> {
}
