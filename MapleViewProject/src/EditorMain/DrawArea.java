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
  public int zoom=0;
  
  public int h=0;
  public int w=0;
  
  // Image in which we're going to draw
  public Image image;
  // Graphics2D object ==> used to draw on
  private Graphics2D g2;
  public boolean Brush = false;
  public boolean crop =false;
  public boolean eraser=false;
  public boolean text = false;
   public boolean shape = false;
   public boolean rotate = false;
   public boolean imgAdj = false;
   public boolean isSaved = false;
   
  int height,width;
  public boolean paintbucket = false;
  Image zoomImage;
  public void tool(int val)
  {
      if(val!=1)
      {
          crop=false;
      }
      if(val!=2)
      {
          Brush=false;
      }
      if(val!=3)
      {
          eraser=false;
      }
      if(val!=4)
      {
          paintbucket=false;
      }
      if(val!=5)
      {
          text=false;
      }
      if(val!=6)
      {
          shape=false;
      }
      if(val!=7)
      {
          rotate=false;
      }
      if(val != 8)
          imgAdj = false;
      
  }
  public int returnTool()
  {
   if(crop)
   {
       return 1;
   }
    if(Brush)
   {
       return 2;
   }
     if(eraser)
   {
       return 3;
   } if(paintbucket)
   {
       return 4;
   }
   if(text)
       return 5;
   if(shape)
       return 6;
   if(rotate)
       return 7;
   if(imgAdj)
       return 8;
     return 0;
  }
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
      zoom=0;
      
  }
  
  
  
  public void zoom(int width,int height)
  {
    if(returnTool()!=0)
    {
        zoom=0;
        tool(10);
    }
    if(zoom==0)
    {
       zoomImage=EditorMain.deepCopy((BufferedImage)image);
       zoom=1;
    }
    int newImageWidth = width;
    int newImageHeight = height;
    setPreferredSize(new Dimension(width, height));
    Image  Rimage= new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);

    Graphics2D g = (Graphics2D) Rimage.getGraphics();

    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.drawImage(zoomImage, 0, 0, newImageWidth , newImageHeight , null);
    g.dispose();
    image=Rimage;
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