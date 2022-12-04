/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filters;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author usman
 */
public class GrayScale {
    public static Image toBlackAndWhite(BufferedImage img)//, int precision) 
    {
        int width = img.getWidth();
        int height = img.getHeight();

    //convert to grayscale
        for(int y = 0; y < height; y++){
          for(int x = 0; x < width; x++){
            int p = img.getRGB(x,y);

            int a = (p>>24)&0xff;
            int r = (p>>16)&0xff;
            int g = (p>>8)&0xff;
            int b = p&0xff;

            //calculate average
            int avg = (r+g+b)/3;

            //replace RGB value with avg
            p = (a<<24) | (avg<<16) | (avg<<8) | avg;

            img.setRGB(x, y, p);
          }
        }
        return img;

    }
}
