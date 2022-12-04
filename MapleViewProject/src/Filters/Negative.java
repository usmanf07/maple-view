
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
public class Negative {
    public static BufferedImage toNegative(Image image) {
        BufferedImage img    = (BufferedImage) image;
        int           width  = img.getWidth(null);
        int           height = img.getHeight(null);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);

                // int a=(p>>24)&0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;

                // subtract RGB from 255
                r = (255 - r);
                g = (255 - g);
                b = (255 - b);
                p = (p << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(x, y, p);
            }
        }

        return img;
    }
    
    
}