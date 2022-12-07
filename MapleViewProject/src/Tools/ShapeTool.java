/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import javax.swing.JComponent;

/**
 *
 * @author usman
 */
public class ShapeTool extends JComponent
{

    public int x1, y1, x2, y2;
    public static Color shapeColor;
    private Graphics2D g2;
    public static int shapetype;
    public static boolean isFill;
    Stack<Shape> shapes;
    Stack<Shape> drawing;
    public static BasicStroke shapeStroke;
    
    public ShapeTool() 
    {
        x1 = y1 = x2 = y2 = 0;
        shapeStroke = new BasicStroke((float) 0.5);
        isFill = false;
        shapetype = 1;
        shapeColor = Color.BLACK;
        setPreferredSize(new Dimension(1080, 1920));
        shapes = new Stack<Shape>();
        drawing  = new Stack<Shape>();
        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }
    
    public void drawPerfectRect(int x, int y, int x2, int y2, boolean filled) 
    {
            int px = Math.min(x,x2);
            int py = Math.min(y,y2);
            int pw=Math.abs(x-x2);
            int ph=Math.abs(y-y2);
            
            g2.drawRect(px, py, pw, ph);
            if(filled)
            {
                g2.fillRect(px, py, pw, ph);
            }
    }
    
    class MyMouseListener extends MouseAdapter {

        public void mousePressed(MouseEvent e)
        {
            x1 = e.getX();
	    y1 = e.getY();
            //repaint();
        }
        
        public void mouseDragged(MouseEvent e) 
        {
            x2=e.getX();
            y2=e.getY();
            
            if (shapetype == 3)
            {
                drawing.push(new Shape(x1, y1, x2, y2,shapeColor, shapetype, isFill, shapeStroke ));
                
	    }
            else{
            if (x1 < x2 && y1 < y2) 
            {
               drawing.push(new Shape(x1, y1, x2 - x1, y2 - y1, shapeColor, shapetype, isFill, shapeStroke ));
            }
            else if (x2 < x1 && y1 < y2) 
            {
                drawing.push( new Shape(x2, y1, x1 - x2, y2 - y1, shapeColor, shapetype, isFill, shapeStroke ));
            }
            else if (x1 < x2 && y2 < y1) 
            {
                drawing.push( new Shape(x1, y2, x2 - x1, y1 - y2, shapeColor, shapetype, isFill, shapeStroke ));
            }
            else if (x2 < x1 && y2 < y1) 
            {
                drawing.push( new Shape(x2, y2, x1 - x2, y1 - y2, shapeColor, shapetype, isFill, shapeStroke ));
            }
            }
            //repaint();
        }

        public void mouseReleased(MouseEvent e) {

            x2=e.getX();
            y2=e.getY();
            
            if (shapetype == 3)
            {
                shapes.push(new Shape(x1, y1, x2, y2,shapeColor, shapetype, isFill, shapeStroke ));
                
	    }
            else{
            if (x1 < x2 && y1 < y2) 
            {
               shapes.push(new Shape(x1, y1, x2 - x1, y2 - y1, shapeColor, shapetype, isFill, shapeStroke ));
            }
            else if (x2 < x1 && y1 < y2) 
            {
                shapes.push( new Shape(x2, y1, x1 - x2, y2 - y1, shapeColor, shapetype, isFill, shapeStroke ));
            }
            else if (x1 < x2 && y2 < y1) 
            {
                shapes.push( new Shape(x1, y2, x2 - x1, y1 - y2, shapeColor, shapetype, isFill, shapeStroke ));
            }
            else if (x2 < x1 && y2 < y1) 
            {
                shapes.push( new Shape(x2, y2, x1 - x2, y1 - y2, shapeColor, shapetype, isFill, shapeStroke));
            }
            }
            
            //repaint();
        }
    }

    public void paintComponent(Graphics g) {
            
        if(g == null)
            g = EditorMain.EditorMain.loadedImages.get(EditorMain.EditorMain.selectedTabIndex).getGraphics();
        //g.drawImage(EditorMain.EditorMain.loadedImages.get(EditorMain.EditorMain.selectedTabIndex), 0, 0, null);
        g2 = (Graphics2D) g;
        g2.setColor(shapeColor);
        
       // g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       for(Shape s : shapes)
       {
           g2.setColor(s.getColor());
           g2.setStroke(s.getStroke());
           if(s.getShapetype() == 1)
            {
                if(!s.fill)
                    g2.drawRect(s.getX1(), s.getY1(), s.getX2(), s.getY2());
                else
                    g2.fillRect(s.getX1(), s.getY1(), s.getX2(), s.getY2());
            }
            
            if(s.getShapetype() == 2)
            {
                if(!s.fill)
                    g2.drawOval(s.getX1(), s.getY1(), s.getX2(), s.getY2());
                else
                    g2.fillOval(s.getX1(), s.getY1(), s.getX2(), s.getY2());
            }
            
             if(s.getShapetype() == 3)
            {
                g2.drawLine(s.getX1(), s.getY1(), s.getX2(), s.getY2());
            }
       }
       
       if (drawing.size() > 0)
       {
	    Shape s = drawing.pop();
            g2.setColor(s.getColor());
           g2.setStroke(s.getStroke());
            if(s.getShapetype() == 1)
            {
                if(!s.fill)
                    g2.drawRect(s.getX1(), s.getY1(), s.getX2(), s.getY2());
                else
                    g2.fillRect(s.getX1(), s.getY1(), s.getX2(), s.getY2());
            }
            
            if(s.getShapetype() == 2)
            {
                if(!s.fill)
                    g2.drawOval(s.getX1(), s.getY1(), s.getX2(), s.getY2());
                else
                    g2.fillOval(s.getX1(), s.getY1(), s.getX2(), s.getY2());
            }
            if(s.getShapetype() == 3)
            {
                g2.drawLine(s.getX1(), s.getY1(), s.getX2(), s.getY2());
            }
       }
       repaint();
        //g.dispose();
    }
    
}
