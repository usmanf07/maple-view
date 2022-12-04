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
public class Mirrorize {
    public static BufferedImage toMirror(Image image) 
    {
        BufferedImage img    = (BufferedImage) image;
        int           width  = img.getWidth(null);
        int           height = img.getHeight(null);

        BufferedImage img1 = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
       for(int y=0;y<height;y++){
         for(int lx=0,rx=2*width-1;lx<width;lx++,rx--){
             int p=img.getRGB(lx, y);
             img1.setRGB(lx, y, p);
             img1.setRGB(rx, y, p);
         }
       }

        return img1;
    }
}
