package fiap.com.br.gamefinder.controller;

import fiap.com.br.gamefinder.model.Platform;
import fiap.com.br.gamefinder.service.PlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platforms")
@RequiredArgsConstructor
public class PlatformController {

    private final PlatformService service;

    @GetMapping
    public ResponseEntity<List<Platform>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Platform> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}