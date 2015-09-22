/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.based.recommendation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class googlePageRank {
    final double damping_factor = 0.85;
    double initialScore = 1;
    HashMap<user, ArrayList<?>> userMatrix;
    
    public googlePageRank(HashMap<user, ArrayList<?>> userMatrix)
    {
        this.userMatrix = userMatrix;
    }
    //HashMap userScore
    public ArrayList<user> getFollowers(Object value)
    {
        ArrayList<user> temp = new ArrayList<user>();
        //iterate through user matrix
        for (Map.Entry<user, ArrayList<?>> entry : userMatrix.entrySet()) 
        {
            ArrayList<?> tempList = entry.getValue();
         
            if (tempList.contains(value))
            {
                temp.add(entry.getKey());
            }
        }
        return temp;
    }
    
    public HashMap<?, Double> calculate(HashMap<?, Double> entity)
    {
        try
        {
            ArrayList<user> followers = new ArrayList<user>();   
            double tempPageRank = 0.0;

            for (int iteration = 1; iteration <= 1; iteration++) //number of iteration in Google Pagerank
            {
                for (Map.Entry<?, Double> entry : entity.entrySet()) //score one by one
                {
                    followers = getFollowers(entry.getKey());
                    if (followers.size() > 0)
                    {
                        for (user follower : followers) {
                            //page rank of A = get those pointing to A / outlink of those pointing to A
                            tempPageRank += (entity.get(follower) / userMatrix.get(follower).size());
                        }
                        tempPageRank = (1 - damping_factor) + (damping_factor * (tempPageRank));
                  
                        entry.setValue(tempPageRank);
                        tempPageRank = 0.0;
                    }
                }
            }
            return entity;
        }
        catch(Exception ex)
        {
            System.out.println("Calculate PageRank: " + ex.getMessage());
            return null;
        }
    }
    
}
