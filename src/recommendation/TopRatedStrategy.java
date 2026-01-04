package recommendation;

import recomTree.GenreTree;
import recomTree.Movie;
import java.util.List;
import java.util.stream.Collectors;

public class TopRatedStrategy implements RecommendationStrategy {
    @Override
    public List<String> recommend(GenreTree tree, String args) {
        // We ignore 'args' here because top-rated doesn't need user input
        List<Movie> allMovies = tree.getRoot().getAllMovies();

        return allMovies.stream()
                .sorted((m1, m2) -> Double.compare(m2.getAverageRating(), m1.getAverageRating()))
                .limit(3)
                .map(m -> m.getTitle() + " (" + String.format("%.1f", m.getAverageRating()) + ")")
                .collect(Collectors.toList());
    }
}