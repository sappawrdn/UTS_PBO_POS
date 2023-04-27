/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugaspbo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Item {
    
    public String code;
    public String name;
    public Float price;
    
    static ArrayList<Item> daftarItem;
    
    public static void loadItemFromDB()
    {
        daftarItem = new ArrayList<Item>();
        Item item;
        try {
            Statement stmt = DBConnector.connection.createStatement();
            
            String sql = "SELECT * FROM item";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                item = new Item();
                item.code =  Integer.toString(rs.getInt("code"));
                
                item.name = rs.getString("name");
                
                item.price = rs.getFloat("price");
                
                daftarItem.add(item);
            }
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
