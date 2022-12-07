/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

/**
 *
 * @author usman
 */
public class ImageAdjuster 
{
    public static int type;
    public static int value;
    
    public static BufferedImage adjustImage(BufferedImage img)
    {
        BufferedImage adjustedImg = null;
        if(type == 0)
        {
            
            float[] factors = new float[] {
                (float)value/10, (float)value/10, (float)value/10
            };
            
            float[] offsets = new float[] {
                (float)0, (float)0, (float)0
            };
            
            RescaleOp op = new RescaleOp(factors, offsets, null);
            adjustedImg = op.filter(img, null);
        }
        
        if(type == 1)
        {
            float[] factors = new float[] {
                (float)10/10, (float)10/10, (float)10/10
            };
            
            float[] offsets = new float[] {
                (float)value, (float)0, (float)0
            };
            
            RescaleOp op = new RescaleOp(factors, offsets, null);
            adjustedImg = op.filter(img, null);
        }
        
        if(type == 2)
        {
            float[] factors = new float[] {
                (float)10/10, (float)10/10, (float)10/10
            };
            
            float[] offsets = new float[] {
                (float)0, (float)value, (float)0
            };
            
            RescaleOp op = new RescaleOp(factors, offsets, null);
            adjustedImg = op.filter(img, null);
        }
        
        if(type == 3)
        {
            float[] factors = new float[] {
                (float)10/10, (float)10/10, (float)10/10
            };
            
            float[] offsets = new float[] {
                (float)0, (float)0, (float)value
            };
            
            RescaleOp op = new RescaleOp(factors, offsets, null);
            adjustedImg = op.filter(img, null);
        }
        return adjustedImg;
    }
}
