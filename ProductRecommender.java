import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ProductRecommender {

    public static void main(String[] args) {
        try {
            // Load sample user-product rating data
            DataModel model = new FileDataModel(new File("data.csv"));

            // Use Pearson correlation to calculate similarity
            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);

            // Define neighborhood of similar users
            UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);

            // Build user-based recommender
            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

            // Recommend 3 products for user with ID 1
            List<RecommendedItem> recommendations = recommender.recommend(1, 3);

            for (RecommendedItem recommendation : recommendations) {
                System.out.println(" Recommended product ID: " + recommendation.getItemID() +
                        " (Score: " + recommendation.getValue() + ")");
            }

        } catch (IOException | TasteException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}