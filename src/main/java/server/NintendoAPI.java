package server;

import com.google.gson.Gson;
import models.Game;
import models.GameStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/api/games")
public class NintendoAPI {
    // Create
    @PostMapping
    @ResponseBody
    public ModelAndView createGame (
            @RequestParam("title") String title,
            @RequestParam("genre") String genre,
            @RequestParam("releaseDate") String releaseDate
    ) {
        Game game = new Game(title, genre, releaseDate);
        GameStorage.games.put(game.id, game);
        return new ModelAndView("forward:/api/games");
    }

    // Read all
    @GetMapping
    @ResponseBody
    public List<Game> getAllGames () {
        Collection<Game> games = GameStorage.games.values();
        return new ArrayList<>(games);
    }

    // Read one
    @GetMapping("/{id}")
    @ResponseBody
    public Game getOneGame (@PathVariable("id") int id) {
        Game result = GameStorage.games.get(id);
        return result;
    }

    // Update
    @PutMapping("/{id}")
    @ResponseBody
    public Game updateGame (
            @PathVariable("id") int id,
            @RequestBody String body
    ) {
        Gson gson = new Gson();
        Game newGame = gson.fromJson(body, Game.class);

        Game game = GameStorage.games.get(id);
        game.title = newGame.title;
        game.genre = newGame.genre;
        game.releaseDate = newGame.releaseDate;
        return game;
    }

    // Destroy
    @DeleteMapping("/{id}")
    @ResponseBody
    public Game deleteGame (@PathVariable("id") int id) {
        Game game = GameStorage.games.get(id);
        GameStorage.games.remove(id);
        return game;
    }
}
