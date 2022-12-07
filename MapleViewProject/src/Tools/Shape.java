/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import static Tools.ShapeTool.isFill;
import static Tools.ShapeTool.shapeColor;
import static Tools.ShapeTool.shapetype;
import java.awt.BasicStroke;
import java.awt.Color;

/**
 *
 * @author usman
 */
public class Shape {
    int x1;
    int y1;
    int x2;
    int y2;
    Color color;
    int shapetype;
    boolean fill;
    private BasicStroke stroke;
    
    public Shape(int x1, int y1, int x2, int y2, Color color, int shapetype, boolean filled, BasicStroke stroke) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.shapetype = shapetype;
        this.fill = filled;
        this.stroke = stroke;
    }
    
    public BasicStroke getStroke()
    {
        return stroke;
    }
    
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public Color getColor() {
        return color;
    }

    public int getShapetype() {
        return shapetype;
    }

    public boolean IsFill() {
        return fill;
    }
    
}
