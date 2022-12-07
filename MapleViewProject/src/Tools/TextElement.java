/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author usman
 */
public class TextElement 
{
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    private Color color;
    //private BasicStroke stroke;
    private String message;

    private Font font;
    
    public TextElement(int x1, int y1, int fontSize, Font font, Color color,  String message)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.y2 = 0;
        this.font = font;
        this.x2 = fontSize;
        this.color = color;
        //this.stroke = stroke;
        this.message = message;
    }
    
    public void setText(int x1, int y1, int fontSize, Font font, Color color,  String message)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.y2 = 0;
        this.font = font;
        this.x2 = fontSize;
        this.color = color;
        //this.stroke = stroke;
        this.message = message;
    }
    
    public String getMessage() 
    {
        return this.message;
    }
    public Font getFont() {
            return this.font;
    }
    public int getx1(){
            return this.x1;
    }
    public int getx2(){
            return this.x2;
    }
    public int gety1(){
            return this.y1;
    }
    public int gety2(){
            return this.y2;
    }
    public Color getColor(){
            return this.color;
    }
//    public BasicStroke getStroke(){
//            return this.stroke;
//    }
    
}
