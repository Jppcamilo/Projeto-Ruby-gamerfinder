package fiap.com.br.gamefinder.controller;

import fiap.com.br.gamefinder.model.Genre;
import fiap.com.br.gamefinder.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService service;

    @GetMapping
    public ResponseEntity<List<Genre>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}