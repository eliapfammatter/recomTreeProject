package commands;

public class ListSubtree implements Command {

    @Override
    public String execute(String args) {
        String targetGenre = (args == null || args.trim().isEmpty()) ? "Root" : args.trim();

        // TODO: Call tree.getSubtree(targetGenre) here

        return "Listing movies under genre '" + targetGenre + "':\n- [No movies found (Tree not connected)]";
    }

    @Override
    public String getName() {
        return "LIST_SUBTREE";
    }

    @Override
    public String getDescription() {
        return "Lists all movies under a genre. Usage: LIST_SUBTREE [Genre]";
    }
}