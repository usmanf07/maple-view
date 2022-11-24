/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import static Tools.BrushTool.brushSize;
import static Tools.BrushTool.brushType;
import static Tools.BrushTool.currentColor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;

/**
 *
 * @author usman
 */
public class EraserTool extends JComponent
{
    private Graphics2D g2;
    
    public EraserTool() {
      
    setDoubleBuffered(false);
    addMouseListener(new MouseAdapter() {
       public void mousePressed(MouseEvent event) {
            
            repaint();
        }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent event) {
            
            repaint();
        }
    });
  }
    protected void paintComponent(Graphics g) 
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    
  }
    
}
