/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorMain;

import static EditorMain.DrawArea.image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author usman
 */
public class NewLoadImage extends JComponent{
    public static Image image;
    private Graphics2D g2;
    
    protected void paintComponent(Graphics g) 
    {
    if (image == null) 
    {
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
        // draw white on entire draw area to clear
        g2.fillRect(0, 0, getSize().width, getSize().height);
  }
}
