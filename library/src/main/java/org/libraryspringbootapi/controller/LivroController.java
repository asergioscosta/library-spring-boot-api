package org.libraryspringbootapi.controller;

import org.libraryspringbootapi.model.entity.Livro;
import org.libraryspringbootapi.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(final LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        return ResponseEntity.ok(livroService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(livroService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody Livro livro) {
        try {
            return ResponseEntity.ok(livroService.save(livro));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Livro livro) {
        try {
            return ResponseEntity.ok(livroService.save(livro));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(livroService.delete(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/total")
    public ResponseEntity getTotal() {
        return ResponseEntity.ok(livroService.count());
    }
}
