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
 
/**
* Component for drawing !
*
* @author sylsau
*
*/
public class DrawArea extends JComponent {
 
  // Image in which we're going to draw
  private Image image;
  // Graphics2D object ==> used to draw on
  private Graphics2D g2;
  private boolean Brush = false;
  private int currentX, currentY, oldX, oldY;
  int height,width;
  
  public void setBrush(boolean flag)
  {
      Brush = flag;
  }
  public DrawArea() {
      
      
    setPreferredSize(new Dimension(500, 600));
    setDoubleBuffered(false);
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // save coord x,y when mouse is pressed
        oldX = e.getX();
        oldY = e.getY();
      }
    });
 
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        // coord x,y when drag mouse
        currentX = e.getX();
        currentY = e.getY();
        
        if (g2 != null && Brush) {
          // draw line if g2 context not null
          
          g2.drawLine(oldX, oldY, currentX, currentY);
          // refresh draw area to repaint
           repaint();
          // store current coords x,y as olds x,y
          oldX = currentX;
          oldY = currentY;
        }
       
      }
    });
  }
 
  protected void paintComponent(Graphics g) {
      
      
    if (image == null) {
     
      image = createImage(getSize().width, getSize().height);
  
      g2 = (Graphics2D) image.getGraphics();
    
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     
      clear();
    }
   
    g.drawImage(image, 0, 0, null);

    
  }
 
  public void Drawer(Image img)
  {
      int w = img.getWidth(null);
      int h = img.getHeight(null);
      height=h;
      width=w;
      setPreferredSize(new Dimension(w, h));
      image = img;
      Graphics g = img.getGraphics();
      g.drawImage(image, 0, 0, null);
      
  }

  
  // now we create exposed methods
  public void clear() {
    g2.setPaint(Color.white);
    // draw white on entire draw area to clear
    g2.fillRect(0, 0, getSize().width, getSize().height);
    g2.setPaint(Color.black);
    repaint();
  }
 
  public void red() {
    // apply red color on g2 context
    g2.setPaint(Color.red);
  }
 
  public void black() {
    g2.setPaint(Color.black);
  }
 
  public void magenta() {
    g2.setPaint(Color.magenta);
  }
 
  public void green() {
    g2.setPaint(Color.green);
  }
 
  public void blue() {
    g2.setPaint(Color.blue);
  }
 
}