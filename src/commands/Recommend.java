package commands;

import recommendation.RecommendationStrategy;
import java.util.List;

public class Recommend implements Command {
    private final RecommendationStrategy strategy;

    public Recommend(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String execute(String args) {
        // We ignore 'args' here because the strategy is already set in the constructor
        // OR you could use 'args' to switch strategies dynamically if you preferred.

        List<String> results = strategy.recommend();

        if (results.isEmpty()) {
            return "No recommendations available.";
        }

        StringBuilder sb = new StringBuilder("Recommendations:\n");
        for (String movie : results) {
            sb.append("- ").append(movie).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getName() {
        return "RECOMMEND";
    }

    @Override
    public String getDescription() {
        return "Gets movie recommendations.";
    }
}