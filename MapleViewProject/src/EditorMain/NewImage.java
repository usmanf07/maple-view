/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EditorMain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author usman
 */
public class NewImage extends JPanel 
{
    private int width;
    private int height;
    private Graphics2D g2;
    public NewImage(int w, int h)
    {
      //  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        width = w;
        height = h;
        this.setSize(width - 3, height - 3); //the 3 accounts for the sp scroller
        this.setPreferredSize(new Dimension(width - 3, height - 3));
        this.setLayout(null);
        setDoubleBuffered(true);
        setLocation(10, 10);
        setBackground(Color.WHITE);
        //currentColor = Color.BLACK;
        //this.fillColor = Color.white;
        setFocusable(true);
        requestFocus();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // erasing behaviour
        g2 = (Graphics2D)g;
        g2.setPaint(Color.white);
        g2.fillRect(0, 0, width, height);
    }
}
