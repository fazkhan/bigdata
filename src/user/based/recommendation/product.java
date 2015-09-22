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
public class product {
    public Integer product_id;
    public String product_name;
    public String product_brand;
    
    public int hashCode(){
        System.out.println("In hashcode");
        int hashcode = 0;
        hashcode = product_id;
        hashcode += product_name.hashCode();
//        hashcode += product_brand.hashCode();
        
        return hashcode;
    }
     
    public boolean equals(Object obj){
        System.out.println("In equals");
        if (obj instanceof product) {
            product pp = (product) obj;
//            return (pp.product_name.equals(this.product_name) && (Objects.equals(pp.product_id, this.product_id) ));
              return ((Objects.equals(pp.product_id, this.product_id) ));
        } else {
            return false;
        }
    }
}
