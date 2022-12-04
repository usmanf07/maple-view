/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import static Tools.BrushTool.brushSize;
import static Tools.BrushTool.brushType;
import static Tools.BrushTool.currentColor;
import java.awt.Color;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;
import static EditorMain.EditorMain.currentImage;
import java.awt.image.BufferedImage;
/**
 *
 * @author usman
 */
public class ColorPickerTool extends JComponent
{
    public ColorPickerTool()
    {
        addMouseListener(new MouseAdapter() {
           public void mouseMoved(MouseEvent e)
           {
               System.out.println("s");
               BufferedImage buffered = (BufferedImage) currentImage;
                int C = buffered.getRGB(e.getX(), e.getY());
                System.out.println(C);
            }
        });
    }
}
