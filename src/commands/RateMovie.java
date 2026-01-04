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

        String trimmedArgs = args.trim();

        // Find the LAST space in the string
        int lastSpaceIndex = trimmedArgs.lastIndexOf(' ');

        if (lastSpaceIndex == -1) {
            return "Error: Invalid format. Usage: RATE_MOVIE <Title> <Rating>";
        }

        // Everything before the last space is the Title
        String titlePart = trimmedArgs.substring(0, lastSpaceIndex).trim();
        // Everything after the last space is the Rating
        String ratingPart = trimmedArgs.substring(lastSpaceIndex + 1).trim();

        try {
            int rating = Integer.parseInt(ratingPart);
            if (rating < 1 || rating > 10) return "Error: Rating must be 1-10.";

            Movie movie = tree.findMovieByTitle(titlePart);
            if (movie == null) {
                return "Error: Movie '" + titlePart + "' not found.";
            }

            movie.addRating(rating);
            return "SUCCESS: Rated '" + titlePart + "' now has average " + String.format("%.1f", movie.getAverageRating());

        } catch (NumberFormatException e) {
            return "Error: Invalid rating number. Ensure the rating is the last number.";
        }
    }

    @Override
    public String getName() { return "RATE_MOVIE"; }

    @Override
    public String getDescription() { return "Rates a movie. Usage: RATE_MOVIE <Title> <Rating>"; }
}