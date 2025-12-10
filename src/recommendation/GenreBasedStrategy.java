package recommendation;

import recomTree.GenreNode;
import recomTree.GenreTree;
import recomTree.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenreBasedStrategy implements RecommendationStrategy {
    private final String targetGenre;

    public GenreBasedStrategy(String targetGenre) {
        this.targetGenre = targetGenre;
    }

    @Override
    public List<String> recommend(GenreTree tree) {
        GenreNode node = tree.findGenre(targetGenre);

        if (node == null) {
            List<String> err = new ArrayList<>();
            err.add("Genre '" + targetGenre + "' not found.");
            return err;
        }

        // Return movies from this genre, formatted nicely
        return node.getAllMovies().stream()
                .limit(5)
                .map(m -> m.getTitle() + " [" + m.getAverageRating() + "]")
                .collect(Collectors.toList());
    }
}