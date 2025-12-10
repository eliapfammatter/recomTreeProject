package commands;

import recomTree.GenreTree;
import recomTree.Movie;
import java.util.UUID;

public class AddMovie implements Command {
    private final GenreTree tree;

    public AddMovie(GenreTree tree) {
        this.tree = tree;
    }

    @Override
    public String execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            return "Error: Usage is ADD_MOVIE <Title> <Genre>";
        }

        String[] parts = args.trim().split("[,\\s]+", 2);
        if (parts.length < 2) {
            return "Error: Missing Genre. Usage is ADD_MOVIE <Title> <Genre>";
        }

        String title = parts[0].trim();
        String genre = parts[1].trim();

        // Check if genre exists, if not, create it under Root
        if (tree.findGenre(genre) == null) {
            tree.addGenre("Root", genre);
        }

        // Create Movie (Generating a random ID and default year 2025 for now)
        Movie movie = new Movie(UUID.randomUUID().toString(), title, 2025);

        boolean success = tree.addMovieToGenre(genre, movie);

        if (success) {
            return "SUCCESS: Added '" + title + "' to '" + genre + "'.";
        } else {
            return "Error: Could not add movie. Genre might not exist.";
        }
    }

    @Override
    public String getName() { return "ADD_MOVIE"; }

    @Override
    public String getDescription() { return "Adds a movie. Usage: ADD_MOVIE <Title> <Genre>"; }
}