/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import javax.swing.JComponent;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

/**
 *
 * @author usman
 */
public class TextTool extends JComponent
{
    //private Stack<TextElement> Texts;
    private TextElement myText;
    public static Color textColor;
    private Graphics2D g2;
    public TextTool()
    {
        textColor = Color.BLACK;
        MyMouseListener listener = new MyMouseListener();
        this.addMouseListener(listener);
    }
       
    class MyMouseListener extends MouseAdapter 
    {
        public void mouseReleased(MouseEvent e) 
        {
            int x1 = e.getX();
            int y1 = e.getY();
            TextDialog td = new TextDialog(null);
            int i = td.showCustomDialog(null);
            if (i == Tools.TextDialog.APPLY_OPTION) 
            {
                if(myText == null)
                    myText = new TextElement(x1, y1, td.getInputSize(), td.getFont(), textColor, td.getText());
                else
                    myText.setText(x1, y1, td.getInputSize(), td.getFont(), textColor, td.getText());
                
            }
            repaint();
        }
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g2 = (Graphics2D) EditorMain.EditorMain.loadedImages.get(EditorMain.EditorMain.selectedTabIndex).getGraphics();
        if(myText != null)
        {
            g2.setColor(myText.getColor());
            g2.setFont(myText.getFont());
            g2.drawString(myText.getMessage(), myText.getx1(), myText.gety1());
        }
        repaint();

    }
    
}
