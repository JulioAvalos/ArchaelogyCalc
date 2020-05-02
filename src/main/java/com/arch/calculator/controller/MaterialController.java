package com.arch.calculator.controller;

import com.arch.calculator.domain.Material;
import com.arch.calculator.services.MaterialService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(MaterialController.BASE_URL)
@RequiredArgsConstructor
public class MaterialController {
    public static final String BASE_URL = "/api/v1/material";

    private final MaterialService service;

    @GetMapping
    public ResponseEntity<List<Material>> lista() {
        var lista = service.listAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> listarPorId(@PathVariable Long id) {
        var obj = service.getById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Material> registrar(@RequestBody Material material) {
        var obj = service.add(material);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdMaterial())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Material> modificar(@RequestBody Material material) {
        var obj = service.modify(material);
        return new ResponseEntity<>(obj, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        var obj = service.getById(id);
        if (obj.getIdMaterial() != null) {
            service.remove(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
