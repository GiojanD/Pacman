
package Objetos;

import Logica.Interfaz;
import Objetos.Paredes;
import Logica.Movimiento;
import Logica.Ventana;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;

public class Pacman {
    private float x;
    private float y;
    private float velocidad;
    private boolean pause;
    private boolean n;
    private boolean dead;
    
    private float ancho;
    private float alto;
    private int dirX;
    private int dirY;
    
    private int angulo;
    private int anguloI;
    private boolean direccion;

    public Pacman(float x, float y, float ancho) {
        this.dirX = 1;
        this.dirY = 0;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = ancho;
        this.angulo = 0;
        this.direccion = true;
        this.velocidad = 1;  
        this.pause = false;
        this.n = true;
    }

    public void paint (Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        
        int angulo = getAngulo();
        
        g2D.setColor(Color.yellow);
        newAngulo();
        g2D.fill(new Arc2D.Float(getX(),getY(),getAncho(),getAlto(),anguloI+angulo,360-angulo*2,Arc2D.PIE));
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

    public int getAnguloI() {
        return anguloI;
    }

    public void setAnguloI(int anguloI) {
        this.anguloI = anguloI;
    }

    
    public float getX() {
        return this.x;
    }
    
    public float getX(float dir) {
        this.x += velocidad*dir;
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY(float dir) {
        this.y += velocidad*dir;
        return this.y;
    }
    
    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    public int getAngulo() {
        return this.angulo;
    }
    
    public void newAngulo() {
        if (!isDead()) {
            if (velocidad != 0) {
                if (this.direccion) {
                    this.angulo += 5;
                        if (angulo == 40) {
                            this.direccion = false;
                        }
                    }
                else {
                    this.angulo -= 5;
                    if (angulo == 0) {
                        this.direccion = true;
                    }
                }
            }
        }  else if (this.angulo < 180){
            this.angulo+=3;
            this.velocidad = 0; 
        } else {
            Ventana.interfaz = new Interfaz();
        
            Ventana.panel.removeAll();
            Ventana.panel.add(Ventana.interfaz, java.awt.BorderLayout.CENTER);
            Ventana.panel.revalidate();
            Ventana.panel.repaint();
        }
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isDireccion() {
        return direccion;
    }

    public void setDireccion(boolean direccion) {
        this.direccion = direccion;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isN() {
        return n;
    }

    public void setN(boolean n) {
        this.n = n;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    
}
