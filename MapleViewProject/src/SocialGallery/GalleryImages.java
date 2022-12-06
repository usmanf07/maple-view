/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocialGallery;

/**
 *
 * @author usman
 */
import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sqlCon.ConnectionUtil;

public class GalleryImages {
    
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    public static List<UserImage> imageList;
    
    public static String loadImagesFromDB()
    {
        String result = "success";
        if(con == null)
        {
            con = ConnectionUtil.conDB();
            System.out.print("conection");
        }
        if(imageList == null)
            imageList = new ArrayList<>();
        
        String query = "select I.id, I.imageurl, u.name from Images i join User u on i.uploadedBy = u.userid";
        
        try {
                    ps = con.prepareStatement(query);
                    rs = ps.executeQuery();
                    if(rs != null)
                    {
                        int i = 0;
                       while(rs.next())
                        {         
                            UserImage ui = new UserImage(rs.getInt("id"), rs.getString("imageurl"), rs.getString("name")); 
                            imageList.add(i, ui);
                            i++;
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Cannot connect to MapleView Server, Try Again Later!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE, null, ex);
                }
        return result;
    }
}
