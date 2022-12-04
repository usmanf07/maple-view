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
public class RedFilter {
    public static BufferedImage toRed(Image image) 
    {
        BufferedImage img    = (BufferedImage) image;
        int           width  = img.getWidth(null);
        int           height = img.getHeight(null);

        for(int y=0;y<height;y++){
          for(int x=0;x<width;x++){
              int p=img.getRGB(x, y);
              int a=(p>>24)&0xff;
              int r=(p>>16)&0xff;
              //set new RGB
              p = ((a<<24) | (0<<8) | (r<<16) | 0);
             img.setRGB(x, y, p);
          }
       }

        return img;
    }
}
