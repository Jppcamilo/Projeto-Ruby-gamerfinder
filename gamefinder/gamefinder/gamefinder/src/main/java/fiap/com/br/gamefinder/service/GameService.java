package fiap.com.br.gamefinder.service;

import fiap.com.br.gamefinder.model.Game;
import fiap.com.br.gamefinder.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository repository;

    public Game getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado"));
    }

    public Page<Game> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Game> getByGenre(Long genreId, Pageable pageable) {
        return repository.findByGenreId(genreId, pageable);
    }

    public Page<Game> getByPlatform(Long platformId, Pageable pageable) {
        return repository.findByPlatformId(platformId, pageable);
    }

    public void removeFromWishlist(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo não encontrado");
        }
    }
}
