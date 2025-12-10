package recommendation;

import recomTree.GenreTree;
import java.util.List;

public interface RecommendationStrategy {
    // Update interface to accept the tree
    List<String> recommend(GenreTree tree);
}