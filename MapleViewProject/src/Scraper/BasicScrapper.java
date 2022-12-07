/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Scraper;

/**
 *
 * @author hp
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class BasicScrapper {

   public BufferedImage Search(String file) throws IOException{
        String results = scrape(file);     
        BufferedImage temp=displayImage(results); 
        return temp;
    }

    public static String scrape(String query) throws IOException {
        Document doc = Jsoup.connect("https://www.google.com/search?site=imghp&tbm=isch&source=hp&q=" + query + "&gws_rd=cr").userAgent("Mozilla/5.0").get();
        
        Elements elements = doc.getElementsByClass("yWs4tf");
       
        ArrayList<String> urls = new ArrayList<>();
         
        String url="null";
        for(Element element : elements) {
            url = element.toString().split("src=")[1];
            url=url.substring(1, url.length()-2);

        }

        return url;
    }

    public BufferedImage displayImage(String urlPath) throws IOException {
        URL url = new URL(urlPath);
        BufferedImage image = ImageIO.read(url);
        return image;
    }

}

