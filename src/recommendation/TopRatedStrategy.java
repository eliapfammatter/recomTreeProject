package recommendation;

import recomTree.GenreTree;
import recomTree.Movie;
import java.util.List;
import java.util.stream.Collectors;

public class TopRatedStrategy implements RecommendationStrategy {
    @Override
    public List<String> recommend(GenreTree tree) {
        // 1. Get all movies from the root (traverses whole tree)
        List<Movie> allMovies = tree.getRoot().getAllMovies();

        // 2. Sort by rating (descending) and limit to top 3
        return allMovies.stream()
                .sorted((m1, m2) -> Double.compare(m2.getAverageRating(), m1.getAverageRating()))
                .limit(3)
                .map(m -> m.getTitle() + " (" + String.format("%.1f", m.getAverageRating()) + ")")
                .collect(Collectors.toList());
    }
}