package models;

public class Game {
    private static int ID = 100;

    public int id;
    public String title;
    public String genre;
    public String releaseDate;

    public Game (String title, String genre, String releaseDate) {
        this.id = ID++;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String toString () {
        return this.title + " || Genre: " + this.genre + " || released: " + this.releaseDate;
    }
}
