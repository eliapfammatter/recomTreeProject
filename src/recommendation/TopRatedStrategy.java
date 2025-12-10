package recommendation;

import java.util.ArrayList;
import java.util.List;

public class TopRatedStrategy implements RecommendationStrategy {
    @Override
    public List<String> recommend() {
        // Placeholder Hardcoded top movies
        List<String> movies = new ArrayList<>();
        movies.add("The Godfather (Rating: 9.2)");
        movies.add("The Shawshank Redemption (Rating: 9.3)");
        movies.add("The Dark Knight (Rating: 9.0)");
        return movies;
    }
}