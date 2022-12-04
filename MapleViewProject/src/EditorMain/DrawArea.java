package EditorMain;

//import static EditorMain.EditorMain.posLabel;
import static EditorMain.EditorMain.currentImage;
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
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
 
import javax.swing.JComponent;
import javax.swing.JLabel;
 
/**
* Component for drawing !
*
* @author sylsau
*
*/
public class DrawArea extends JComponent {
 public Stack<Image> undo = new Stack <Image> ();
  public Stack<Image> redo = new Stack <Image> ();
  // Image in which we're going to draw
  public Image image;
  // Graphics2D object ==> used to draw on
  private Graphics2D g2;
  private boolean Brush = false;
  int height,width;
  public boolean paintbucket = false;
  public void setBrush(boolean flag)
  {
      Brush = flag;
  }
  public DrawArea(int w, int h) {
      
      width = w;
      height = h;
    setPreferredSize(new Dimension(w, h));
    setDoubleBuffered(false);
    
  }
 
  
  
  
  protected void paintComponent(Graphics g) {
      
      
      super.paintComponent(g);
      
    if (image == null) 
    {
     
        image= new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);

        g2 = (Graphics2D) image.getGraphics();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        clear();
    }
   
    g.drawImage(image, 0, 0, null);
    

  }
  
  
  public void crop()
  {
     BufferedImage currentImage =(BufferedImage)image;
        BufferedImage curr   =(BufferedImage)image;

        BufferedImage img = curr.getSubimage(100, 100, 200, 200);
        BufferedImage copyOfImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        Drawer(img);
      
      
  }
  public Image getImage()
  {
      return image;
  }
 
  public void Drawer(Image img)
  {
      
      int w = img.getWidth(null);
      int h = img.getHeight(null);

      setPreferredSize(new Dimension(w, h));
      image = img;
      Graphics g = img.getGraphics();
      g.drawImage(image, 0, 0, null);
      repaint();
      
  }

  
  // now we create exposed methods
  public void clear() {
    g2.setPaint(Color.white);
    // draw white on entire draw area to clear
    g2.fillRect(0, 0, getSize().width, getSize().height);
    g2.setPaint(Color.black);
    repaint();
  }
 
}