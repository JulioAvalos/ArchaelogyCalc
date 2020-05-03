package com.arch.calculator.controller;

import com.arch.calculator.domain.Artifact;
import com.arch.calculator.services.ArtifactService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(ArtifactController.BASE_URL)
@RequiredArgsConstructor
public class ArtifactController {
    public static final String BASE_URL = "/api/v1/artifact";

    private final ArtifactService service;

    @GetMapping
    public ResponseEntity<List<Artifact>> lista() {
        var lista = service.listAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artifact> listarPorId(@PathVariable Long id) {
        var obj = service.getById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artifact> registrar(@RequestBody Artifact Artifact) {
        var obj = service.add(Artifact);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.get_id())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Artifact> modificar(@RequestBody Artifact Artifact) {
        var obj = service.modify(Artifact);
        return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        var obj = service.getById(id);
        if (obj.get_id() != null) {
            service.remove(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
