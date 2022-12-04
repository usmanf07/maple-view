/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 *
 * @author usman
 */
public class Rotate {
    public static Image Rotation(Image image,double degree)
    {
         BufferedImage img    = (BufferedImage) image;
        int           width  = img.getWidth(null);
        int           height = img.getHeight(null);
         BufferedImage rotate=new BufferedImage(height,width,img.getType());
        for(int h=0;h<height;h++){
         for(int w=0;w<width;w++){

                    rotate.setRGB((height-1)-h,w,img.getRGB(w, h));


             }
        }
        return img;
    }
}
