package fiap.com.br.gamefinder.repository;

import fiap.com.br.gamefinder.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    // Spring Data cria as queries automáticas baseadas nestes nomes:
    Page<Game> findByGenreId(Long genreId, Pageable pageable);
    Page<Game> findByPlatformId(Long platformId, Pageable pageable);
}