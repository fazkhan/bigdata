/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.based.recommendation;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class user {
    public Integer user_id;
    public String user_name;
    public String email;
    
     public int hashCode(){
        System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = user_id;
        hashcode += user_name.hashCode();
        hashcode += email.hashCode();
        
        return hashcode;
    }
     
    public boolean equals(Object obj){
        System.out.println("In equals");
        if (obj instanceof user) {
            user pp = (user) obj;
            //return (pp.user_name.equals(this.user_name) && (Objects.equals(pp.user_id, this.user_id) )&& pp.email.equals(this.email));
            return ((Objects.equals(pp.user_id, this.user_id) ));
        } else {
            return false;
        }
    }
}
