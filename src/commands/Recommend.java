package commands;

import recommendation.RecommendationStrategy;
import recomTree.GenreTree;
import java.util.List;

public class Recommend implements Command {
    private final GenreTree tree;
    private final RecommendationStrategy strategy;

    public Recommend(GenreTree tree, RecommendationStrategy strategy) {
        this.tree = tree;
        this.strategy = strategy;
    }

    @Override
    public String execute(String args) {
        // Pass the user arguments (args) to the strategy
        List<String> results = strategy.recommend(tree, args);

        if (results.isEmpty()) {
            return "No recommendations found.";
        }

        // Check if the result is an error message (simple check)
        if (results.get(0).startsWith("Error:") || results.get(0).contains("not found")) {
            return results.get(0);
        }

        StringBuilder sb = new StringBuilder("Recommendations:\n");
        for (String s : results) {
            sb.append("- ").append(s).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String getName() { return "RECOMMEND"; }

    @Override
    public String getDescription() { return "Gets recommendations based on a strategy. RECOMMEND_TOP for top rated movies or RECOMMEND_GENRE <Genre> for genre based movies"; }
}