/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.based.recommendation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.SpearmanCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

/**
 *
 * @author Admin
 */
public class PearsonCorrelation extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public PearsonCorrelation() throws IOException {
        initComponents();
//        createUserPreferenceFile();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstRecommendedItems = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        cmboboxUser = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(lstUser2);

        jScrollPane2.setViewportView(lstUser1);

        jScrollPane3.setViewportView(lstUser4);

        jScrollPane4.setViewportView(lstUser3);

        jLabel1.setText("User 1");

        jLabel2.setText("User 2");

        jLabel3.setText("User 3");

        jLabel4.setText("User 4");

        jScrollPane5.setViewportView(lstRecommendedItems);

        jLabel5.setText("Recommend for User");

        cmboboxUser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        cmboboxUser.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmboboxUserItemStateChanged(evt);
            }
        });

        jScrollPane6.setViewportView(lstUser5);

        jLabel6.setText("User 5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(88, 88, 88)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4)))
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmboboxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmboboxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static double generateRandomRatings()
    {
        double max = 10.0;
        double min = 6.0;
        DecimalFormat format = new DecimalFormat("#.##");
        double r;
        Random random = new Random();
          
        while(true)
        {
            
//            r = (random.nextDouble() * max) + min;
//            r = Double.parseDouble(format.format(r));
            double range = max - min;
            
            double scaled = random.nextDouble() * range;
            scaled = Double.parseDouble(format.format(scaled));
            double shifted = scaled + min;
//            System.out.println("Shifted: " + shifted);
            if (shifted % 0.5 == 0)
            {
                r = shifted;
//                System.out.println("Random: " + shifted);
                break;
            }
        }
            
      System.out.println("final : " + r);
        return r;  
        
    }
    
    private static void createUserPreferenceFile() throws IOException
    {
        File file = new File("userPreference.csv");
        if (file.exists())
            file.delete();
        FileWriter fileWriter = new FileWriter("userPreference.csv");
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        String userPreferences = "";
        String temp = "";
        try
        {
            Scanner scan = new Scanner(new File("input1.csv"));
            while(scan.hasNextLine())
            {
                temp = scan.nextLine();
                userPreferences = temp.split(",")[0] + "," + 
                temp.split(",")[1] + "," + 
                generateRandomRatings() + "\n";
                fileWriter.write(userPreferences);
            }
            
            
            fileWriter.close();
            scan.close();
            
        }
        catch(Exception ex)
        {
            System.out.println("Create User Preference File Exception: " + ex.getMessage());
        }
    }
    private void cmboboxUserItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmboboxUserItemStateChanged
        // TODO add your handling code here:
        try
        {
            
            DataModel model = new FileDataModel(new File("userPreference.csv"));

            UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
            //UserSimilarity similarity1 = new SpearmanCorrelationSimilarity(model);
            
            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
            //UserNeighborhood neighborhood1 = new ThresholdUserNeighborhood(0.1, similarity1, model);
            
            
            
            UserBasedRecommender recommender = new GenericBooleanPrefUserBasedRecommender(model, neighborhood, similarity);
            UserBasedRecommender recommender1 = new GenericUserBasedRecommender(model, neighborhood, similarity);
            
            
            
            
            
            
            List<RecommendedItem> recommendations = recommender.recommend(Integer.parseInt(cmboboxUser.getSelectedItem().toString()), 3);
            List<RecommendedItem> recommendations1 = recommender1.recommend(Integer.parseInt(cmboboxUser.getSelectedItem().toString()), 3);
           
           
            System.out.println("Recommendation length: " + recommendations.size());
            result = new ArrayList<>();
            for (RecommendedItem item : recommendations)
            {
                System.out.println(table.get(Integer.parseInt(Long.toString(item.getItemID()))) + " : " + item.getValue());
                result.add(table.get(Integer.parseInt(Long.toString(item.getItemID()))) + " : " + item.getValue());
            }
            
            System.out.println("Boolean recommendation: ");
            for (RecommendedItem item : recommendations1)
            {
//              System.out.println(table.get(Integer.parseInt(Long.toString(item.getItemID()))) + " : " + item.getValue());
//               result.add(table.get(Integer.parseInt(Long.toString(item.getItemID()))) + " : " + item.getValue());
            }
            
            lstRecommendedItems.setListData(result.toArray());
        }
        catch(IOException | TasteException | NumberFormatException ex)
        {
            System.out.println("Here is the exception: " + ex.getMessage());
        }
        
    }//GEN-LAST:event_cmboboxUserItemStateChanged

    /**
     * @param args the command line arguments
     */
    private static ArrayList<String> User1, User2, User3, User4, User5;
    private static String input;
    private static Hashtable table = new Hashtable();
    
       
    private ArrayList<String> result;
    
    public static void GetUSerData() throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("userPreference.csv"));
     //   scan.useDelimiter(",");
        User1 = new ArrayList<>();
        User2 = new ArrayList<>();
        User3 = new ArrayList<>();
        User4 = new ArrayList<>();
        User5 = new ArrayList<>();
        String temp = "";
        
        while(scan.hasNext())
        {
            input = "";
            
            temp = scan.next();
            input = temp.split(",")[0];
            
            switch (input) {
                case "1":
                    User1.add(temp.split(",")[1] + ":" + table.get(Integer.parseInt(temp.split(",")[1])).toString() + " : " + temp.split(",")[2]);
                    
                    break;
                case "2":
                    User2.add(temp.split(",")[1] + ":" + table.get(Integer.parseInt(temp.split(",")[1])).toString() + " : " + temp.split(",")[2]);
                    break;
                case "3":
                    User3.add(temp.split(",")[1] + ":" + table.get(Integer.parseInt(temp.split(",")[1])).toString() + " : " + temp.split(",")[2]);
                    break;
                case "4":
                    User4.add(temp.split(",")[1] + ":" + table.get(Integer.parseInt(temp.split(",")[1])).toString() + " : " + temp.split(",")[2]);
                    break;
                case "5":
                User5.add(temp.split(",")[1] + ":" + table.get(Integer.parseInt(temp.split(",")[1])).toString() + " : " + temp.split(",")[2]);
                break;
            }
            
            
        }
        scan.close();
    }
    
    
    public static void populateUsers()throws NullPointerException
    {
        
        lstUser1.setListData(User1.toArray());
        lstUser2.setListData(User2.toArray());
        lstUser3.setListData(User3.toArray());
        lstUser4.setListData(User4.toArray());
        lstUser5.setListData(User5.toArray());
        
    }
    public static void main(String args[]) throws FileNotFoundException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PearsonCorrelation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PearsonCorrelation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PearsonCorrelation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PearsonCorrelation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new PearsonCorrelation().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(PearsonCorrelation.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    createUserPreferenceFile();
                } catch (IOException ex) {
                    Logger.getLogger(PearsonCorrelation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        table.put(10,"Dove Shampoo");
        table.put(11,"Head n shoulders");
        table.put(12,"Pantene");
        table.put(13,"Beats");
        table.put(14,"Skull Candy");
        table.put(15,"Senheizer");
        table.put(16,"Monster");
        table.put(17,"Dove");
        table.put(18,"Sunsilk");
        table.put(19,"Shirt");
        GetUSerData();
        populateUsers();
        
        
        
      
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmboboxUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList lstRecommendedItems;
    private static final javax.swing.JList lstUser1 = new javax.swing.JList();
    private static final javax.swing.JList lstUser2 = new javax.swing.JList();
    private static final javax.swing.JList lstUser3 = new javax.swing.JList();
    private static final javax.swing.JList lstUser4 = new javax.swing.JList();
    private static final javax.swing.JList lstUser5 = new javax.swing.JList();
    // End of variables declaration//GEN-END:variables
}
