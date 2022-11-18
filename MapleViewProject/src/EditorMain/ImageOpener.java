/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorMain;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


/**
 *
 * @author hp
 */



public class ImageOpener {
    
     public static String Path()
    {
        JFileChooser browserImageFile = new JFileChooser();
        int showOpenDiaglogue=browserImageFile.showOpenDialog(null);
        String path="";
        if(showOpenDiaglogue == JFileChooser.APPROVE_OPTION)
        {
           path=browserImageFile.getSelectedFile().getAbsolutePath();
        }
        return path;
    }
    public static Image OpenImage()
  {
      
     String path = Path();
     BufferedImage img=null;
    try {    
           img = ImageIO.read(new File(path));
          
      } catch (IOException ex) {
          Logger.getLogger(DrawArea.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      
      
      
      return img;
     
     

      
  }
}
