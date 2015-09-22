/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.based.recommendation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class postgres {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    HashMap<user, ArrayList<?>> userData;
    public HashMap<Object, Double> entities;
    
    public postgres()
    {
        try
        {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cahootsy_test", "postgres", "endoscopeDEFENCE1");
        statement = connection.createStatement();
        entities = new HashMap<Object, Double>();
        }
        catch(Exception ex)
        {
            System.out.println("Connection error: " + ex.getMessage());
        }
    }
    
    
    public HashMap populateLovedProducts()
    {
        userData = new HashMap<user, ArrayList<?>>();
        user tempUser;
        product tempProduct;
        ArrayList<Object> tempValue;
        try
        {
            
            resultSet = statement.executeQuery("select \n" +
            "	votes.voter_id as user, votes.votable_id loves_product, " +
            "	users.name || ' ' || users.last_name as user_name, " +
            "	users.email, " +
            "	products.name as product_name, " +
            "	brands.name as product_brand " +
            "	from votes " +
            "	inner join users " +
            "	on users.id = votes.voter_id " +
            "	inner join products " +
            "	on products.id = votes.votable_id " +
            "	inner join brands " +
            "	on products.brand_id = brands.id " +
            "	where vote_scope = 'want' ");
            int count = 0;
            
            while(resultSet.next())
            {
                tempUser = new user();
                tempProduct = new product();
                
                tempUser.email = resultSet.getString("email");
                tempUser.user_id = resultSet.getInt("user");
                tempUser.user_name = resultSet.getString("user_name");
                
                tempProduct.product_id = resultSet.getInt("loves_product");
                tempProduct.product_name = resultSet.getString("product_name");
                tempProduct.product_brand = resultSet.getString("product_brand");

                //populate hashmap (user, initialScore)
                if (!entities.containsKey(tempUser))
                {
                    entities.put(tempUser, 1.0);
                }
                
                //populate hashmap (product, initialScore)
                if (!entities.containsKey(tempProduct))
                {
                    entities.put(tempProduct, 1.0);
                }
                
                if (userData.containsKey(tempUser))
                {
                    tempValue = (ArrayList<Object>)userData.get(tempUser);
                    tempValue.add(tempProduct);
                    
                    userData.put(tempUser, tempValue);
                }
                else
                {
                    tempValue = new ArrayList<>();
                    tempValue.add(tempProduct);
                    userData.put(tempUser, tempValue);
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("error populateLovedProducts: " + ex.getMessage());
        }
        return userData;
    }
    
    
    public HashMap populateUserFollowees()
    {
        user tempUser, tempFollowee;
        ArrayList<Object> tempValue;
        userData = new HashMap<user, ArrayList<?>>();
        try
        {
            resultSet = statement.executeQuery("select distinct followee_name, "
                + "followee, followee_email, user_name, user_email, user_id " +
                "from" +
                "(" +
                " select " +
                "	users.name || ' ' || users.last_name  as user_name, owner_id as user_id," +
                "	users.email as user_email," +
                "	trackable_id as followee," +
                "	(select users.name || ' ' || users.last_name from users where id = trackable_id) as followee_name," +
                "	(select email from users where id = trackable_id) as followee_email" +
                " from activities" +
                " inner join users" +
                " on users.id = owner_id" +
                " where key = 'notification.user.following' " +
                ") as a");
            
            int count = 0;
            
            while(resultSet.next())
            {
                tempUser = new user();
                tempFollowee = new user();
            
                tempUser.email = resultSet.getString("user_email");
                tempUser.user_id = resultSet.getInt("user_id");
                tempUser.user_name = resultSet.getString("user_name");
                
                tempFollowee.email = resultSet.getString("followee_email");
                tempFollowee.user_id = resultSet.getInt("followee");
                tempFollowee.user_name = resultSet.getString("followee_name");
                                
                //populate hashmap (user, initialScore)
                if (!entities.containsKey(tempUser))
                {
                    entities.put(tempUser, 1.0);
                }
                if (!entities.containsKey(tempFollowee))
                {
                    entities.put(tempFollowee, 1.0);
                }
                
                if (userData.containsKey(tempUser))
                {
                    tempValue = (ArrayList<Object>)userData.get(tempUser);
                    tempValue.add(tempFollowee);
                    
                    userData.put(tempUser, tempValue);
                }
                else
                {
                    tempValue = new ArrayList<>();
                    tempValue.add(tempFollowee);
                    userData.put(tempUser, tempValue);
                }
            }
        }
            catch (Exception ex)
        {
            System.out.println("error populateUserFollowees: " + ex.getMessage());
        }
        return userData;
    }
    
    public HashMap mergeUserData(HashMap<user, ArrayList<?>> Data1, HashMap<user, ArrayList<?>> Data2)
    {
        HashMap<String, ArrayList<?>> matrix = new HashMap<String, ArrayList<?>>();
        ArrayList<Object> tempValue;
        
        for (Map.Entry<user, ArrayList<?>> entry : Data1.entrySet())
        {
            if (Data2.containsKey(entry.getKey()))
            {
                tempValue = (ArrayList<Object>)Data2.get(entry.getKey());
                tempValue.addAll(entry.getValue());
                Data2.put(entry.getKey(), tempValue);
            }
            else
            {
                Data2.put(entry.getKey(), entry.getValue());
            }
        }
        
//        Data1.forEach((String, v) -> matrix.putIfAbsent(String, v));
        
        
        return Data2;
    }
    
    public HashMap populateUsers(HashMap<user, ArrayList<?>> userMatrix)
    {
        user tempUser;
        
        HashMap<user, Double> userScore = new HashMap<user, Double>();
        try
        {   
            Set<user> users = userMatrix.keySet();
            for (user user : users) {
                userScore.put(user, 1.0);
            }
           /* resultSet = statement.executeQuery("select name || ' ' || last_name as user_name, email, id as user_id from users where (name || ' ' || last_name) is not null");
            while(resultSet.next())
            {
                tempUser = new user();
                tempUser.email = resultSet.getString("email");
                tempUser.user_name = resultSet.getString("user_name");
                tempUser.user_id = resultSet.getInt("user_id");
                
                userScore.put(tempUser, 1.0);
            }
             return userScore;*/
            return userScore;
        }
        catch (Exception ex)
        {
            System.out.println("error populateUsers: " + ex.getMessage());
            return null;
        }
    }
    
    public HashMap populateProducts()
    {
        product tempProduct;
        
        HashMap<product, Double> productScore = new HashMap<product, Double>();
        try
        {   
            resultSet = statement.executeQuery("select id as product_id, name as product_name from products where name is not null");
             while(resultSet.next())
            {
                tempProduct = new product();
                tempProduct.product_id = resultSet.getInt("product_id");
                tempProduct.product_name = resultSet.getString("product_name");
                
                productScore.put(tempProduct, 1.0);
            }
             return productScore;
            
        }
            catch (Exception ex)
        {
            System.out.println("error populateProducts: " + ex.getMessage());
            return null;
        }
    }
}
