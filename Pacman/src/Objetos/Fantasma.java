
package Objetos;


import Logica.Interfaz;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Fantasma {
    private float x;
    private float y;
    private float width;
    private float height;
    private int dir;
    private int dirX;
    private int dirY;
    private static boolean weak;
    private boolean dead;
    public static int weakTimer;

    private boolean lockedX;
    private boolean lockedY;
    private boolean free;
    private int timeFree;
    
    private Color color;
    private int speed;

    public Fantasma(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.dirX = 0;
        this.dirY = -1;
        this.dir = 2;
        this.width = width;
        this.height = height;
        this.color = color;
        this.speed = 1;

        this.dead = false;
        this.free = false;
        this.timeFree = 0;
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        
        dir=(isWeak())?4:dir;
        
        int xt, yt;
        
        switch (dir) {
            case 0:
                xt = 0;
                yt = 1;
                break;
            case 1:
                xt = -1;
                yt = 0;
                break;
            case 2:
                xt = 1;
                yt = 0;
                break;
            case 3:
                xt = 0;
                yt = -1;
                break;
            default:
                xt = 0;
                yt = 0;              
                break;
        }
        
        Path2D linea = new Path2D.Float();
        Boolean isFirst = true;
        
        float[] xPoints1 = {5,9,9,11,11,12,12,13,13,14,14,13,13,12,12,11,11,10,10,8,8,6,6,4,4,3,3,2,2,1,1,0,0,1,1,2,2,3,3,5};
        float[] yPoints1 = {0,0,1,1,2,2,3,3,6,6,14,14,13,13,12,12,13,13,14,14,12,12,14,14,13,13,12,12,13,13,14,14,6,6,3,3,2,2,1,1};
        
        for (int i = 0; i < xPoints1.length; i++) {
            xPoints1[i] *= (width/14);
            yPoints1[i] *= (height/14);
            xPoints1[i] += x;
            yPoints1[i] += y;
            if (isFirst) {
                linea.moveTo(xPoints1[i],yPoints1[i]);
                isFirst = false;
            } else {
                linea.lineTo(xPoints1[i],yPoints1[i]);
            }
        }
        linea.closePath();
        
        g2D.setColor(isWeak()?Color.blue:color);
        if (isDead()) g2D.setColor(new Color(0,0,0,1));
        g2D.fill(linea);
        
        linea.reset();
        isFirst = true;
        
        float[] xPoints2 = {3,5,5,6,6,5,5,3,3,2,2,3};
        float[] yPoints2 = {3,3,4,4,7,7,8,8,7,7,4,4};
        
        for (int i = 0; i < xPoints2.length; i++) {
            xPoints2[i] *= (width/14);
            yPoints2[i] *= (height/14);
            xPoints2[i] += x;
            yPoints2[i] += y;
            
            if (isFirst) {
                linea.moveTo(xPoints2[i],yPoints2[i]);
                isFirst = false;
            } else {
                linea.lineTo(xPoints2[i],yPoints2[i]);
            }
        }
        linea.closePath();
        
        g2D.setColor(isWeak()?Color.blue:Color.white);
        if (isDead()) g2D.setColor(Color.white);
        g2D.fill(linea);
        
        linea.reset();
        isFirst = true;
        
        float[] xPoints3 = {9,11,11,12,12,11,11,9,9,8,8,9};
        float[] yPoints3 = {3,3,4,4,7,7,8,8,7,7,4,4};
        
        for (int i = 0; i < xPoints3.length; i++) {
            xPoints3[i] *= (width/14);
            yPoints3[i] *= (height/14);
            xPoints3[i] += x;
            yPoints3[i] += y;
            if (isFirst) {
                linea.moveTo(xPoints3[i],yPoints3[i]);
                isFirst = false;
            } else {
                linea.lineTo(xPoints3[i],yPoints3[i]);
            }
        }
        linea.closePath();
        g2D.fill(linea);

        linea.reset();
        isFirst = true;
        float[] xPoints4 = {9+xt,11+xt,11+xt,9+xt};
        float[] yPoints4 = {5+yt,5+yt,7+yt,7+yt};
        
        for (int i = 0; i < xPoints4.length; i++) {
            xPoints4[i] *= (width/14);
            yPoints4[i] *= (height/14);
            xPoints4[i] += x;
            yPoints4[i] += y;
            if (isFirst) {
                linea.moveTo(xPoints4[i],yPoints4[i]);
                isFirst = false;
            } else {
                linea.lineTo(xPoints4[i],yPoints4[i]);
            }
        }
        linea.closePath();

        g2D.setColor(isWeak()?Color.white:Color.blue);
        if (isDead()) g2D.setColor(Color.blue);
        g2D.fill(linea);
        
        linea.reset();
        isFirst = true;
        float[] xPoints5 = {3+xt,5+xt,5+xt,3+xt};
        float[] yPoints5 = {5+yt,5+yt,7+yt,7+yt};
        
        for (int i = 0; i < xPoints5.length; i++) {
            xPoints5[i] *= (width/14);
            yPoints5[i] *= (height/14);
            xPoints5[i] += x;
            yPoints5[i] += y;
            if (isFirst) {
                linea.moveTo(xPoints5[i],yPoints5[i]);
                isFirst = false;
            } else {
                linea.lineTo(xPoints5[i],yPoints5[i]);
            }
        }
        linea.closePath();
        
        g2D.fill(linea);
        
        if (isWeak()) {
            if (isDead()) g2D.setColor(new Color(0,0,0,1));
            g2D.fill(new Rectangle2D.Float(x + 1*(width/14),y + 10*(height/14),1*(width/14),(height/14)));
            g2D.fill(new Rectangle2D.Float(x + 2*(width/14),y + 9*(height/14),2*(width/14),(height/14)));
            g2D.fill(new Rectangle2D.Float(x + 4*(width/14),y + 10*(height/14),2*(width/14),(height/14)));
            g2D.fill(new Rectangle2D.Float(x + 6*(width/14),y + 9*(height/14),2*(width/14),(height/14)));
            g2D.fill(new Rectangle2D.Float(x + 8*(width/14),y + 10*(height/14),2*(width/14),(height/14)));
            g2D.fill(new Rectangle2D.Float(x + 10*(width/14),y + 9*(height/14),2*(width/14),(height/14)));
            g2D.fill(new Rectangle2D.Float(x + 12*(width/14),y + 10*(height/14),1*(width/14),(height/14)));
        }
    }

    public static boolean isWeak() {
        return weak;
    }

    public static void setWeak(boolean weak) {
        Fantasma.weak = weak;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getDirX() {
        return dirX;
    }

    public void setDirX(int dirX) {
        this.dirX = dirX;
    }

    public int getDirY() {
        return dirY;
    }

    public void setDirY(int dirY) {
        this.dirY = dirY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    

    public void update(Paredes paredes,float x, float y) {
        
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public static int getWeakTimer() {
        return weakTimer;
    }

    public static void setWeakTimer(int weakTimer) {
        Fantasma.weakTimer = weakTimer;
    }
    
    public boolean isColliding() {
        double bx = x + width/2;
        double by = y + height/2;
        
        double cx = Interfaz.getC().getX() + Interfaz.getC().getAncho()/2;
        double cy = Interfaz.getC().getY() + Interfaz.getC().getAncho()/2;
        
        double dx = bx - cx;
        double dy = by - cy;
        
        if (Math.sqrt(dx*dx + dy*dy)<width) {
            return true;
        }
        return false;
    }

    public boolean isLockedX() {
        return lockedX;
    }

    public void setLockedX(boolean lockedX) {
        this.lockedX = lockedX;
    }

    public boolean isLockedY() {
        return lockedY;
    }

    public void setLockedY(boolean lockedY) {
        this.lockedY = lockedY;
    }
    
    
}
