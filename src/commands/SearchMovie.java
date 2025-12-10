package commands;

public class SearchMovie implements Command {

    @Override
    public String execute(String args) {
        if (args == null || args.trim().isEmpty()) {
            return "Error: Usage is SEARCH_MOVIE <Title>";
        }

        String title = args.trim();

        // TODO: Call tree.search(title) here
        // Placeholder response:
        return "Searching for '" + title + "'... [Movie Found/Not Found]";
    }

    @Override
    public String getName() {
        return "SEARCH_MOVIE";
    }

    @Override
    public String getDescription() {
        return "Searches for a movie details. Usage: SEARCH_MOVIE <Title>";
    }
}