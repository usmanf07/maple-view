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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BasicScrapper {
static List<String> resultUrls = new ArrayList<String>();

    private static final int num = 5;				// Number of images to save in the current directory
	private static final String key = "AIzaSyCziPZ3niIitvsE8A7H5Kgx6aq91WnIJq8";	// Google Custom Search API key 
	//private static final String qry="aeron";					// Query for the search
	private static final String cx = "c317930f0b4874d6a";		// The custom search engine ID
	private static int errors = 0;						
	
	// Returns search results (JSON format) in each call for specified API key, query, start index and custom search engine id (cx).
	public static String getResults(String query, int nums) throws IOException {
		
            //query.replace(' ', '+');
		URL url = new URL(	// Construct the URL
	            "https://www.googleapis.com/customsearch/v1?key="+key+ "&cx="+ cx + "&q="+ query + "&searchType=image&num="+nums);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();			// Open the connection
		conn.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));	// Get the stream
		
		// Construct the string to return from the reponse
		StringBuilder response = new StringBuilder();
		String line = "";
		while ((line = br.readLine()) != null)
		    response.append(line+"\n");
		    
		br.close();				// Close the reader
		conn.disconnect();			// Close the connection
		return response.toString();
	}


   public List<String> Search(String searchString, int nums) throws IOException{
        
        searchString = searchString.replace(' ', '+');    
        String resp = getResults(searchString, nums);
        String[] lines; 
        lines = resp.split("\n");
        findLinksAndSave(lines);
        
    
        //BufferedImage temp = displayImage(results); 
        return resultUrls;
    }
    public static void findLinksAndSave(String [] response) throws IOException 
    {
        int i = 0;
        while (i<response.length) {
                if(response[i].contains("\"link\": \"")){
                       
                        String link=response[i].substring(response[i].indexOf("\"link\": \"")+("\"link\": \"").length(), response[i].indexOf("\","));
                        resultUrls.add(link);
                       // System.out.println(link);
                }
                i++;
        }
    }
//   
//    public static void scrape(String str) throws IOException, ParseException 
//    {
//        
//        URL url = new URL("https://www.googleapis.com/customsearch/v1?q="+str+"&cx=c317930f0b4874d6a&searchType=image&rights=cc_publicdomain&num=3&key="+key);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Accept", "application/json");
//        BufferedReader br = new BufferedReader(new InputStreamReader(
//                (conn.getInputStream())));
//        String output;
//        System.out.println("Output from Server .... \n");
//        int i = 0;
//        while ((output = br.readLine()) != null) {
//            if(i > 3)
//                break;
//            //if(output.contains("\"link\": \"")){                
//                String link=output;//.substring(output.indexOf("\"link\": \"")+("\"link\": \"").length(), output.indexOf("\","));
//                System.out.println(link);
//                resultUrls.add(link);
//           // }   
//            i++;
//        }
//        conn.disconnect(); 
////        URL url = new URL("https://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" + str);
////        URLConnection connection = url.openConnection();
////        
////         String line;
////        StringBuilder builder = new StringBuilder();
////        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
////        while((line = reader.readLine()) != null) {
////            builder.append(line);
////        }
////        
////        JSONObject json = new JSONObject(builder.toString());
////        String imageUrl = json.getJSONObject("responseData").getJSONArray("results").getJSONObject(0).getString("url");
//        //for (Element element : el) {
//        //    resultUrls.add(element.attr("data-src"));
//        //}
//    
//        System.out.println("number of results: " + resultUrls.size());
//
////        for (String imageUrl : resultUrls) 
////        {
////            System.out.println(imageUrl);
////        }
////        Document doc = Jsoup.connect("https://www.google.com/search?site=imghp&tbm=isch&source=hp&q=" + query + "&gws_rd=cr").userAgent("Mozilla/5.0").get();
////        
////        Elements elements = doc.getElementsByClass("yWs4tf");
////       
////        ArrayList<String> urls = new ArrayList<>();
////         
////        String url="null";
////        for(Element element : elements) {
////            url = element.toString().split("src=")[1];
////            url=url.substring(1, url.length()-2);
////
////        }
////
////        return url;
//    }
//
//    public BufferedImage displayImage(String urlPath) throws IOException {
//        URL url = new URL(urlPath);
//        BufferedImage image = ImageIO.read(url);
//        return image;
//    }

}

