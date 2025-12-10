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
        // Pass the tree to the strategy
        List<String> results = strategy.recommend(tree);

        if (results.isEmpty()) {
            return "No recommendations found.";
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
    public String getDescription() { return "Gets recommendations based on a strategy."; }
}