package models;

import java.util.*;

public class GameStorage {
    public static Map<Integer, Game> games;
    static {
        games = new HashMap<>();
        Game breathOfWild = new Game("Zelda: Breath of the Wild", "Adventure", "March 3, 2017");
        Game majorasMask = new Game("Zelda: Majora's Mask", "Adventure", "April 27, 2000");
        Game smashBros = new Game("Super Smash Bros", "Fighter", "January 21, 1999");
        Game starfox = new Game("Star Fox 64", "Shooter", "April 27, 1997");
        Game jamesBond = new Game("Goldeneye 007", "Shooter", "August 25, 1997");

        games.put(breathOfWild.id, breathOfWild);
        games.put(majorasMask.id, majorasMask);
        games.put(smashBros.id, smashBros);
        games.put(starfox.id, starfox);
        games.put(jamesBond.id, jamesBond);
    }

}
