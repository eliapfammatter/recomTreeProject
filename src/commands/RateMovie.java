package commands;

public class RateMovie implements Command {

    @Override
    public String execute(String args) {
        // Expecting args like: "Inception 5"
        if (args == null || args.trim().isEmpty()) {
            return "Error: Usage is RATE_MOVIE <Title> <Rating (1-10)>";
        }

        String[] parts = args.trim().split("[,\\s]+", 2);

        if (parts.length < 2) {
            return "Error: Missing Rating. Usage is RATE_MOVIE <Title> <Rating>";
        }

        String title = parts[0];
        String ratingStr = parts[1];

        try {
            int rating = Integer.parseInt(ratingStr);
            if (rating < 1 || rating > 10) {
                return "Error: Rating must be between 1 and 10.";
            }

            // TODO: Call tree.rateMovie(title, rating) here

            return "SUCCESS: Rated '" + title + "' - " + rating + "/10.";

        } catch (NumberFormatException e) {
            return "Error: Rating must be a number.";
        }
    }

    @Override
    public String getName() {
        return "RATE_MOVIE";
    }

    @Override
    public String getDescription() {
        return "Rates a movie. Usage: RATE_MOVIE <Title> <Rating>";
    }
}