package fiap.com.br.gamefinder.service;

import fiap.com.br.gamefinder.model.Genre;
import fiap.com.br.gamefinder.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository repository;

    public List<Genre> findAll() {
        return repository.findAll();
    }

    public Genre findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Gênero não encontrado"));
    }
}