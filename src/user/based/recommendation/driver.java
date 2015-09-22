/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.based.recommendation;

import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Admin
 */
public class driver {
    public static void main(String[] args)  {
        postgres db = new postgres();

         //get the products that user love
         HashMap<user, ArrayList<?>> userLovedProducts = db.populateLovedProducts();
         
         //get user followees
         HashMap<user, ArrayList<?>> userFollowees = db.populateUserFollowees();
         
         //create matrix
         HashMap<user, ArrayList<?>> userMatrix = db.mergeUserData(userLovedProducts, userFollowees);
         HashMap<Object, Double> userScore = db.entities;
//         HashMap<user, Double> userScore = db.populateUsers(userMatrix);
         
         //HashMap<product, Double> productScore = db.populateProducts();
         
     /*    user user1 = new user();
         user1.email = "user1@gmail.com";
         user1.user_id = 1;
         user1.user_name = "rao";
         
         user user2 = new user();
         user2.email = "user2@gmail.com";
         user2.user_id = 2;
         user2.user_name = "ali";
         
         HashMap<user, ArrayList<?>> userData = new HashMap<user, ArrayList<?>>();
         ArrayList<user> userList = new ArrayList<user>();
         userList.add(user2);
         userData.put(user1, userList);
         userList = new ArrayList<user>();
         userList.add(user1);
         userData.put(user2, userList);
         
         HashMap<user, Double> userScore = new HashMap<user, Double>();
         userScore.put(user1, 40.0);
         userScore.put(user2, 40.0);
         */
         
         googlePageRank pageRank = new googlePageRank(userMatrix);
         HashMap<?, Double> userFinalScore = pageRank.calculate(userScore);
//         HashMap<?, Double> productFinalScore = pageRank.calculate(productScore);
         System.out.println("This is a test");
         
    }
}
