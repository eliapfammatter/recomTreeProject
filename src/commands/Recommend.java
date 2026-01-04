package commands;

import recommendation.RecommendationStrategy;
import recomTree.GenreTree;
import java.util.List;

public class Recommend implements Command {
    private final GenreTree tree;
    private final RecommendationStrategy strategy;
    private final String commandName;

    public Recommend(GenreTree tree, RecommendationStrategy strategy, String commandName) {
        this.tree = tree;
        this.strategy = strategy;
        this.commandName = commandName;
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
    public String getName() { return commandName; }

    @Override
    public String getDescription() { return "Gets recommendations based on a strategy."; }
}