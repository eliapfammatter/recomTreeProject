package commands;

import recomTree.GenreTree;
import recomTree.Movie;

public class RateMovie implements Command {
    private final GenreTree tree;

    public RateMovie(GenreTree tree) {
        this.tree = tree;
    }

    @Override
    public String execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            return "Error: Usage is RATE_MOVIE <Title> <Rating>";
        }

        String[] parts = args.trim().split("[,\\s]+", 2);
        if (parts.length < 2) {
            return "Error: Missing Rating.";
        }

        String title = parts[0].trim();
        try {
            int rating = Integer.parseInt(parts[1].trim());
            if (rating < 1 || rating > 10) return "Error: Rating must be 1-10.";

            Movie movie = tree.findMovieByTitle(title);
            if (movie == null) {
                return "Error: Movie '" + title + "' not found.";
            }

            movie.addRating(rating);
            return "SUCCESS: Rated '" + title + "' now has average " + String.format("%.1f", movie.getAverageRating());

        } catch (NumberFormatException e) {
            return "Error: Invalid rating number.";
        }
    }

    @Override
    public String getName() { return "RATE_MOVIE"; }

    @Override
    public String getDescription() { return "Rates a movie. Usage: RATE_MOVIE <Title> <Rating>"; }
}