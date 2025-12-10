package recommendation;

import java.util.ArrayList;
import java.util.List;

public class GenreBasedStrategy implements RecommendationStrategy {
    private String genre;

    // We can pass parameters (like the requested genre) via the constructor
    public GenreBasedStrategy(String genre) {
        this.genre = genre;
    }

    @Override
    public List<String> recommend() {
        // Placeholder: Returns generic movies for the requested genre
        List<String> movies = new ArrayList<>();
        movies.add("Popular " + genre + " Movie 1");
        movies.add("Classic " + genre + " Movie 2");
        movies.add("New " + genre + " Release");
        return movies;
    }
}
