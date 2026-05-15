package fiap.com.br.gamefinder.controller;

import fiap.com.br.gamefinder.model.Game;
import fiap.com.br.gamefinder.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    // AGORA INJETAMOS O SERVICE, NÃO MAIS O REPOSITORY!
    private final GameService gameService;
    private final PagedResourcesAssembler<Game> pagedResourcesAssembler;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Game>> getById(@PathVariable Long id) {
        // Chama o Service em vez do Repository
        Game game = gameService.getById(id);

        EntityModel<Game> resource = EntityModel.of(game);

        resource.add(linkTo(methodOn(GameController.class).getById(id)).withSelfRel().withTitle(game.getTitle()));

        if (game.getGenre() != null) {
            resource.add(linkTo(methodOn(GameController.class).getByGenre(game.getGenre().getId(), null))
                    .withRel("same-genre").withTitle("Games in " + game.getGenre().getName() + " genre"));
        }

        if (game.getPlatform() != null) {
            resource.add(linkTo(methodOn(GameController.class).getByPlatform(game.getPlatform().getId(), null))
                    .withRel("same-platform").withTitle("Games on " + game.getPlatform().getName()));
        }

        if (game.isInWishlist()) {
            resource.add(linkTo(methodOn(GameController.class).removeFromWishlist(id))
                    .withRel("remove-from-wishlist")
                    .withTitle("Remove " + game.getTitle() + " from wishlist")
                    .withType("GET"));
        }

        return ResponseEntity.ok(resource);
    }

    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<Game>>> getAll(Pageable pageable) {
        // Chama o Service
        Page<Game> games = gameService.getAll(pageable);

        PagedModel<EntityModel<Game>> pagedModel = pagedResourcesAssembler.toModel(games, game -> {
            EntityModel<Game> model = EntityModel.of(game);
            model.add(linkTo(methodOn(GameController.class).getById(game.getId())).withSelfRel().withTitle(game.getTitle()));
            return model;
        });

        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping("/genres/{genreId}")
    public ResponseEntity<PagedModel<EntityModel<Game>>> getByGenre(@PathVariable Long genreId, Pageable pageable) {
        // Chama o Service
        Page<Game> games = gameService.getByGenre(genreId, pageable);

        PagedModel<EntityModel<Game>> pagedModel = pagedResourcesAssembler.toModel(games, game -> {
            EntityModel<Game> model = EntityModel.of(game);
            model.add(linkTo(methodOn(GameController.class).getById(game.getId())).withSelfRel().withTitle(game.getTitle()));
            return model;
        });

        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping("/platforms/{platformId}")
    public ResponseEntity<PagedModel<EntityModel<Game>>> getByPlatform(@PathVariable Long platformId, Pageable pageable) {
        // Chama o Service
        Page<Game> games = gameService.getByPlatform(platformId, pageable);

        PagedModel<EntityModel<Game>> pagedModel = pagedResourcesAssembler.toModel(games, game -> {
            EntityModel<Game> model = EntityModel.of(game);
            model.add(linkTo(methodOn(GameController.class).getById(game.getId())).withSelfRel().withTitle(game.getTitle()));
            return model;
        });

        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping("/wishlist/{id}")
    public ResponseEntity<String> removeFromWishlist(@PathVariable Long id) {
        // Chama o Service para simular a remoção
        gameService.removeFromWishlist(id);
        return ResponseEntity.ok("Removido da wishlist com sucesso!");
    }
}