package server;

import commands.*;
import recomTree.GenreNode;
import recomTree.GenreTree;
import recomTree.Movie;
import recommendation.GenreBasedStrategy;
import recommendation.TopRatedStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CommandProcessor {
    private final Map<String, Command> commandMap;
    private final GenreTree genreTree;

    public CommandProcessor() {
        // 1. Initialize the Tree
        GenreNode root = new GenreNode("Root");
        this.genreTree = new GenreTree(root);

        // 2. Fill with sample data
        initializeSampleData();

        // 3. Register commands
        commandMap = new HashMap<>();
        registerCommands();
    }

    private void initializeSampleData() {
        // Add Main Genres
        genreTree.addGenre("Root", "Action");
        genreTree.addGenre("Root", "SciFi");
        genreTree.addGenre("Root", "Drama");
        genreTree.addGenre("Root", "Comedy");
        genreTree.addGenre("Root", "Animation");

        // Add Sub-Genres
        genreTree.addGenre("Action", "Superhero");
        genreTree.addGenre("SciFi", "Cyberpunk");

        // Add Movies
        addWithRating("Action", "Mad Max: Fury Road", 2015, 8.1);
        addWithRating("Action", "John Wick", 2014, 7.4);

        addWithRating("Superhero", "The Dark Knight", 2008, 9.0);
        addWithRating("Superhero", "Avengers: Endgame", 2019, 8.4);

        addWithRating("SciFi", "Inception", 2010, 8.8);
        addWithRating("SciFi", "Interstellar", 2014, 8.6);
        addWithRating("Cyberpunk", "Blade Runner 2049", 2017, 8.0);

        addWithRating("Drama", "The Shawshank Redemption", 1994, 9.3);
        addWithRating("Drama", "The Godfather", 1972, 9.2);

        addWithRating("Animation", "Spirited Away", 2001, 8.6);
        addWithRating("Animation", "The Lion King", 1994, 8.5);
    }

    private void addWithRating(String genre, String title, int year, double rating) {
        Movie movie = new Movie(UUID.randomUUID().toString(), title, year);
        movie.addRating(rating);
        genreTree.addMovieToGenre(genre, movie);
    }

    private void registerCommands() {
        commandMap.put("HELP", new Help(commandMap));
        commandMap.put("QUIT", new Quit());

        commandMap.put("ADD_MOVIE", new AddMovie(genreTree));
        commandMap.put("RATE_MOVIE", new RateMovie(genreTree));
        commandMap.put("SEARCH_MOVIE", new SearchMovie(genreTree));
        commandMap.put("LIST_SUBTREE", new ListSubtree(genreTree));
        commandMap.put("RECOMMEND_TOP", new Recommend(genreTree, new TopRatedStrategy()));
    }

    public String process(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Error: Empty command.";
        }

        String[] parts = input.trim().split("\\s+", 2);
        String commandName = parts[0].toUpperCase();
        String arguments = parts.length > 1 ? parts[1] : "";

        Command command = commandMap.get(commandName);

        if (command != null) {
            return command.execute(arguments);
        } else {
            return "Error: Unknown command '" + commandName + "'. Type HELP for a list.";
        }
    }
}