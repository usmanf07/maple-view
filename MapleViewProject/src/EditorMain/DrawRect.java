package EditorMain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author hp
 */
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

    public class DrawRect extends JComponent {

        int x, y, x2, y2;

        DrawRect() {
            setPreferredSize(new Dimension(500, 600));
            x = y = x2 = y2 = 0; // 
            MyMouseListener listener = new MyMouseListener();
            addMouseListener(listener);
            addMouseMotionListener(listener);
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
            super.paintComponent(g);
            g.setColor(Color.RED);
            drawPerfectRect(g, x, y, x2, y2);
        }

    }
