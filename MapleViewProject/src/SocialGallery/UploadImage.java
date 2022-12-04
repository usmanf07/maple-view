/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocialGallery;

import UserVerification.User;
import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.*;

import java.io.File;
import java.io.FileInputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

import org.apache.commons.codec.binary.Base64;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqlCon.ConnectionUtil;


/**
 *
 * @author usman
 */
public class UploadImage {
    public static final String TAG = "ImgUploader";
    private static final String API_KEY = "ab4decde1a0f5b117a2a57344a7ac5f3";

    private static final String API_URL = "https://api.imgbb.com/1/upload";
    private static final String USER_AGENT = "imgbbUpldr";
    private static final int TIMEOUT = 50000;
    private static java.sql.Connection con = null;
    private static PreparedStatement ps = null;
    
    public static String Upload(File f, String imgName)
    {
       String result = "success";
        
        if(con == null)
            con = ConnectionUtil.conDB();
        
        UploadParameters parameters = new UploadParameters();
        try {
            parameters.toMap(f, imgName);
        } catch (IOException ex) {
            Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Response response = Jsoup.connect(API_URL)
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .method(Method.POST)
                    .data(parameters.toMap(f, imgName))
                    .timeout(TIMEOUT)
                    .userAgent(USER_AGENT)
                    .execute();
            
            int statusCode = response.statusCode(); 
            if(statusCode == 200){
                System.out.println(statusCode);
                
            
            Document doc = Jsoup.parse(response.body(), "", Parser.xmlParser());
            //System.out.println(doc);
            
            String n = doc.toString();
            String id = n.substring(15, 15 + 7);
            String url = "https://ibb.co/" + id;
           // int currentUserid = User.currentUser.userID;
            String query = "Insert into Images(imageurl, uploadedBy) values (?, ?)";
                try {
                    ps = con.prepareStatement(query);
                    ps.setString(1, url);
                    ps.setInt(2, 1);
                    ps.execute();
                } catch (SQLException ex) {
                    Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
            return result;
            }
        } catch (IOException ex) {
            throw new RuntimeException("I/O exception was catched while try to upload image!", ex);
        }
        return null;
    }
}
