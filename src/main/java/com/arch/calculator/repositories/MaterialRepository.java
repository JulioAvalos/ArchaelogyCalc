package com.arch.calculator.repositories;

import com.arch.calculator.domain.Material;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialRepository
        extends MongoRepository<Material, Long> {
}
