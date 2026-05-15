package fiap.com.br.gamefinder.service;

import fiap.com.br.gamefinder.model.Platform;
import fiap.com.br.gamefinder.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatformService {

    private final PlatformRepository repository;

    public List<Platform> findAll() {
        return repository.findAll();
    }

    public Platform findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Plataforma não encontrada"));
    }
}