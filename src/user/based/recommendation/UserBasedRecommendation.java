/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.based.recommendation;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 *
 * @author Admin
 */
//libraries required: 
/* 
commons-math3
guava
slf4j-api
slf4j-nop
mahout-core
mahout-integration
mahout-math
*/
public class UserBasedRecommendation {
    /**
     * @param args the command line arguments
     */
    
    //input -> 
    public static void main(String[] args)  {
        // TODO code application logic here
        System.out.println("This is a test");
     Hashtable table = new Hashtable();
       
    
         table.put(10,"Dove Shampoo");
        table.put(11,"Head n shoulders");
        table.put(12,"Pantene");
        table.put(13,"Beats");
        table.put(14,"Skull Candy");
        table.put(15,"Senheizer");
        table.put(16,"Monster");
        table.put(17,"Dove");
        table.put(18,"Sunsilk");
        
        try
        {
            DataModel model = new FileDataModel(new File("input1.csv"));

            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
            
            
            UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
            
            List<RecommendedItem> recommendations = recommender.recommend(2, 3);
           
            System.out.println("Recommendation length: " + recommendations.size());
            for (RecommendedItem item : recommendations)
            {
                System.out.println(table.get(Integer.parseInt(Long.toString(item.getItemID()))));
            }
        }
        catch(Exception ex)
        {
            System.out.println("Here is the exception: " + ex.getMessage());
        }
    }
    
}
