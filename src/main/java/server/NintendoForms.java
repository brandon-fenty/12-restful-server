package server;

import models.Game;
import models.GameStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/games")
public class NintendoForms {
    // List all games page
    @GetMapping
    public String showAllGames (Model model) {
        Collection<Game> games = GameStorage.games.values();
        List<Game> list = new ArrayList<>(games);

        model.addAttribute("games", games);
        return "all_games";
    }

    // Create form
    @GetMapping("/new")
    public String createGameForm () {
        return "create_game";
    }

    // Update form
    @GetMapping("/{id}/edit")
    public String editGameForm (
            @PathVariable("id") int id,
            Model model
    ) {
        Game game = GameStorage.games.get(id);

        model.addAttribute("id", game.id);
        model.addAttribute("title", game.title);
        model.addAttribute("genre", game.genre);
        model.addAttribute("releaseDate", game.releaseDate);

        return "edit_game";
    }
}
