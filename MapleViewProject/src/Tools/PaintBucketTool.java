/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import static Tools.BrushTool.currentColor;
import static Tools.EraserTool.eraserSize;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

/**
 *
 * @author usman
 */
public class PaintBucketTool extends JComponent
{
    Graphics2D g2;
    public static Color currentColor;
    
    public PaintBucketTool()
    {
        currentColor = Color.BLACK;
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
                             public void mousePressed(MouseEvent event) {
                                 g2.setColor(currentColor);
                                 repaint();
                             }
                         });
        addMouseMotionListener(new MouseMotionAdapter() {
                                   public void mouseDragged(MouseEvent event) {
                                      g2.setColor(currentColor);
                                       repaint();
                                   }
                               });
    }
    
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Image img = EditorMain.EditorMain.loadedImages.get(EditorMain.EditorMain.selectedTabIndex);
        g2 = (Graphics2D) img.getGraphics();
        g2.setColor(currentColor);
        g2.fillRect(0, 0, img.getWidth(this), img.getHeight(this));
    }
}
