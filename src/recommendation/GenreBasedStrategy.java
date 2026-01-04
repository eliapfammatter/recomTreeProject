package recommendation;

import recomTree.GenreNode;
import recomTree.GenreTree;
import recomTree.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenreBasedStrategy implements RecommendationStrategy {

    @Override
    public List<String> recommend(GenreTree tree, String args) {
        if (args == null || args.trim().isEmpty()) {
            List<String> err = new ArrayList<>();
            err.add("Error: Please specify a genre (e.g., RECOMMEND_GENRE Action).");
            return err;
        }

        String targetGenre = args.trim();
        GenreNode node = tree.findGenre(targetGenre);

        if (node == null) {
            List<String> err = new ArrayList<>();
            err.add("Genre '" + targetGenre + "' not found.");
            return err;
        }

        return node.getAllMovies().stream()
                .limit(5)
                .map(m -> m.getTitle() + " [" + String.format("%.1f", m.getAverageRating()) + "]")
                .collect(Collectors.toList());
    }
}