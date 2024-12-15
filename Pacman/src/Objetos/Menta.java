
package Objetos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Menta {
    private final float x;
    private final float y;
    private final boolean special;
    private final float size;
    public static Color color;
    
    public Menta(int x, int y, boolean special) {
        this.x = x;
        this.y = y;
        this.special = special;
        this.size = (special)?6:2;
        this.color = Color.white;
    }
    
    public void paint(Graphics g) {
            Graphics2D g2D = (Graphics2D)g;
            g2D.setColor((isSpecial())?color:Color.white);
            
            g2D.fill(new Ellipse2D.Float(x, y, size*2, size*2));
    }
    

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isSpecial() {
        return special;
    }
  
}