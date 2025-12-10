package commands;

public class AddMovie implements Command {

    @Override
    public String execute(String args) {
        // Expecting args like: "Inception SciFi" or "The Matrix, Action"
        if (args == null || args.trim().isEmpty()) {
            return "Error: Usage is ADD_MOVIE <Title> <Genre>";
        }

        // Simple split logic (assuming space or comma separation for now)
        // In the final version, you might want more robust parsing for titles with spaces
        String[] parts = args.trim().split("[,\\s]+", 2);

        if (parts.length < 2) {
            return "Error: Missing Genre. Usage is ADD_MOVIE <Title> <Genre>";
        }

        String title = parts[0];
        String genre = parts[1];

        // TODO: Call tree.addMovie(title, genre) here

        return "SUCCESS: Added movie '" + title + "' to genre '" + genre + "'.";
    }

    @Override
    public String getName() {
        return "ADD_MOVIE";
    }

    @Override
    public String getDescription() {
        return "Adds a movie to the catalog. Usage: ADD_MOVIE <Title> <Genre>";
    }
}