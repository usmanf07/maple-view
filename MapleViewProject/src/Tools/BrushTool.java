/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;
/*
/**
 *
 * @author usman
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;
 
import javax.swing.JComponent;
 

public class BrushTool extends JComponent {
 private final ArrayList<MyPoint> point = new ArrayList<>();

  // Image in which we're going to draw
 
  private Graphics2D g2;
  public static float brushSize = 10;
  public static Color currentColor;
    public static String brushType = "Normal";
  public BrushTool() {
      currentColor = Color.BLACK;
    setDoubleBuffered(false);
    addMouseListener(new MouseAdapter() {
       public void mousePressed(MouseEvent event) {
            MyPoint p = new MyPoint();
            p.point = event.getPoint();
            p.size = brushSize;
            p.color = currentColor;
            p.type = brushType;
            point.add(p);
            repaint();
        }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent event) {
            MyPoint p = new MyPoint();
            p.point = event.getPoint();
            p.size = brushSize;
            p.color = currentColor;
            p.type = brushType;
            point.add(p);
            repaint();
            
        }
    });
  }
 
  protected void paintComponent(Graphics g) 
  {
    super.paintComponent(g);
    g2 = (Graphics2D) g;
    g2.setColor(currentColor);
    
        for (int i = 1; i < point.size(); i++){
            if(point.get(i).type.equals("Normal"))
            {
                g2.setPaint(point.get(i).color);
                g2.setStroke(new BasicStroke(point.get(i).size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.draw(new Line2D.Float(point.get(i-1).point, point.get(i).point));
            }
            
             else if(point.get(i).type.equals("Calligraphy"))
            {
                    double angle = 45;
                    g2.setStroke(new BasicStroke(point.get(i).size));

                    double dx = (point.get(i).size - 2.0) * Math.cos(angle);
                    double dy = (point.get(i).size - 2.0) * Math.sin(angle);
                    g2.setPaint(point.get(i).color);
                    double x = point.get(i-1).point.x;
                    double y = point.get(i).point.y;

                    double startX = x + dx;
                    double startY = y + dy;
                    double endX = x - dx;
                    double endY = y - dy;

                    g2.draw(new Line2D.Double(startX, startY, endX, endY));

            }
        }
    
   
  }

}