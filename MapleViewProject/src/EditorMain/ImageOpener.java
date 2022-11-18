/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorMain;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

/**
 *
 * @author hp
 */



public class ImageOpener extends JComponent{
    
    private Image image;
    private Graphics2D g2;
    public int width, height;
    
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
    public static BufferedImage OpenImage()
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
    
    protected void paintComponent(Graphics g) 
    {
        if (image == null) 
        {
          // image to draw null ==> we create
          image = createImage(getSize().width, getSize().height);

          g2 = (Graphics2D) image.getGraphics();
          //enable antialiasing
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          // clear draw area
          clear();
        }

        g.drawImage(image, 0, 0, null);
  }
    public void clear() 
    {
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, getSize().width, getSize().height);
    }
}

