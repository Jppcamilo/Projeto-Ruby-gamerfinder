package fiap.com.br.gamefinder.model;

import jakarta.persistence.*;
import org.mockito.internal.util.Platform;

import java.time.LocalDate;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Double rating;
    private String coverUrl;
    private String backdropUrl;
    private boolean inWishlist;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Platform platform;
}