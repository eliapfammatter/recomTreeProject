package commands;

import recomTree.GenreTree;
import recomTree.Movie;

public class SearchMovie implements Command {
    private final GenreTree tree;

    public SearchMovie(GenreTree tree) {
        this.tree = tree;
    }

    @Override
    public String execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            return "Error: Provide a movie title.";
        }

        Movie movie = tree.findMovieByTitle(args.trim());

        if (movie != null) {
            return "Found: " + movie.getTitle() + " (" + movie.getYear() + ") - Rating: " + String.format("%.1f", movie.getAverageRating());
        } else {
            return "Movie '" + args.trim() + "' not found.";
        }
    }

    @Override
    public String getName() { return "SEARCH_MOVIE"; }

    @Override
    public String getDescription() { return "Searches for a movie."; }
}