package com.arch.calculator.controller;

import com.arch.calculator.domain.Recipe;
import com.arch.calculator.services.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(RecipeController.BASE_URL)
@RequiredArgsConstructor
public class RecipeController {
    public static final String BASE_URL = "/api/v1/recipe";

    private final RecipeService service;

    @GetMapping
    public ResponseEntity<List<Recipe>> lista() {
        var lista = service.listAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> listarPorId(@PathVariable Long id) {
        var obj = service.getById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Recipe> registrar(@RequestBody Recipe recipe) {
        var obj = service.add(recipe);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.get_id())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Recipe> modificar(@RequestBody Recipe recipe) {
        var obj = service.modify(recipe);
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
