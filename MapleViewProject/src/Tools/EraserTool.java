
/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;

import java.util.ArrayList;

import javax.swing.JComponent;

/**
 *
 * @author usman
 */
public class EraserTool extends JComponent {
    public static float eraserSize = 10;
    private final ArrayList<MyPoint> point      = new ArrayList<>();

    // Image in which we're going to draw
//  Image image; 
    private Graphics2D g2;

    public EraserTool() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
                             public void mousePressed(MouseEvent event) {
                                 MyPoint p = new MyPoint();

                                 p.point = event.getPoint();
                                 p.size  = eraserSize;
                                 p.color = Color.WHITE;
                                 p.type  = "eraser";
                                 point.add(p);
                                 repaint();
                             }
                         });
        addMouseMotionListener(new MouseMotionAdapter() {
                                   public void mouseDragged(MouseEvent event) {
                                       MyPoint p = new MyPoint();

                                       p.point = event.getPoint();
                                       p.size  = eraserSize;
                                       p.color = Color.WHITE;
                                       p.type  = "eraser";
                                       point.add(p);
                                       repaint();
                                   }
                               });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) EditorMain.EditorMain.loadedImages.get(EditorMain.EditorMain.selectedTabIndex).getGraphics();
        g2.setColor(Color.WHITE);

        for (int i = 1; i < point.size(); i++) {
            g2.setPaint(point.get(i).color);
            g2.setStroke(new BasicStroke(point.get(i).size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.draw(new Line2D.Float(point.get(i - 1).point, point.get(i).point));
        }
    }
}
