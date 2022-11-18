/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorMain;

/**
 *
 * @author usman
 */
import static EditorMain.DrawArea.image;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

    public class CropFunction extends JPanel {
        
        private Image image;
    // Graphics2D object ==> used to draw on
        private Graphics2D g2;
    // Mouse coordinates
       private int x, y, x2, y2;

        CropFunction() {
            
            x = y = x2 = y2 = 0; // 
            MyMouseListener listener = new MyMouseListener();
            addMouseListener(listener);
            addMouseMotionListener(listener);
        }
        
        public void CropImage()
        {
           image = EditorMain.getImage();
        }
        public void setStartPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setEndPoint(int x, int y) {
            x2 = (x);
            y2 = (y);
        }

        public void drawPerfectRect(Graphics g, int x, int y, int x2, int y2) {
            int px = Math.min(x,x2);
            int py = Math.min(y,y2);
            int pw=Math.abs(x-x2);
            int ph=Math.abs(y-y2);
            g.drawRect(px, py, pw, ph);
        }

        class MyMouseListener extends MouseAdapter {

            public void mousePressed(MouseEvent e) {
                setStartPoint(e.getX(), e.getY());
            }

            public void mouseDragged(MouseEvent e) {
                setEndPoint(e.getX(), e.getY());
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                setEndPoint(e.getX(), e.getY());
                repaint();
            }
        }

        public void paintComponent(Graphics g) {
            if (image == null) 
            {
                // image to draw null ==> we create
                image = createImage(getSize().width, getSize().height);

                g2 = (Graphics2D) image.getGraphics();
                //enable antialiasing
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            }
   
            g.drawImage(image, 0, 0, null);
            super.paintComponent(g);
            g.setColor(Color.RED);
            drawPerfectRect(g, x, y, x2, y2);
        }

    }
