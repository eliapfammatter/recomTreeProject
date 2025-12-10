package commands;

import recomTree.GenreNode;
import recomTree.GenreTree;
import recomTree.Movie;
import java.util.List;

public class ListSubtree implements Command {
    private final GenreTree tree;

    public ListSubtree(GenreTree tree) {
        this.tree = tree;
    }

    @Override
    public String execute(String args) {
        String target = (args == null || args.trim().isEmpty()) ? "Root" : args.trim();
        GenreNode node = tree.findGenre(target);

        if (node == null) {
            return "Error: Genre '" + target + "' not found.";
        }

        List<Movie> movies = node.getAllMovies(); // Uses the recursive method in GenreNode
        if (movies.isEmpty()) {
            return "Genre '" + target + "' has no movies.";
        }

        StringBuilder sb = new StringBuilder("Movies in " + target + ":\n");
        for (Movie m : movies) {
            sb.append("- ").append(m.getTitle()).append(" (").append(m.getYear()).append(")\n");
        }
        return sb.toString();
    }

    @Override
    public String getName() { return "LIST_SUBTREE"; }

    @Override
    public String getDescription() { return "Lists movies in a genre."; }
}