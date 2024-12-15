
package Logica;


import Objetos.Menta;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Puntos {
    private static long score;
    private static long timer;
    
    private List<Menta> mentas;
    private Iterator<Menta> itr;
    
    public Puntos(int[][] grid, int x, int y, int c) {
        Puntos.score = 0;
        Puntos.timer = 0;
        this.mentas = new LinkedList<>();
        generarMentas(grid,x,y,c);
    }
    
    private void generarMentas(int[][] grid,int x, int y, int c) {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 19; j++) {
                if (grid[i][j]==0) {
                    AgregarMenta(x+8+j*c,y+8+i*c,false);
                } else if (grid[i][j]==4) {
                    AgregarMenta(x+4+j*c,y+3+i*c,true);
                }
            }
        }
    }
    
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        
        BasicStroke grosor1 = new BasicStroke(1);
        g2D.setStroke(grosor1);
        
        g2D.setColor(Color.white);
        Font fuente = new Font("Roboto",Font.BOLD,20);
        g2D.setFont(fuente);
        g2D.drawString("Score: "+Puntos.getScore(), 50, 40);
        g2D.drawString("Time: " +Puntos.getTimer(),300,40);
        itr = mentas.iterator();
        while (itr.hasNext()) {
            itr.next().paint(g);
        }
    }
 
    
    private void AgregarMenta(int x, int y, boolean special) {
        mentas.add(new Menta(x,y,special));
    }

    public static long getScore() {
        return score;
    }

    public static void setScore(long score) {
        Puntos.score = score;
    }

    public static long getTimer() {
        return timer;
    }

    public static void setTimer(long timer) {
        Puntos.timer = timer;
    }

    public List<Menta> getMentas() {
        return mentas;
    }

    public void setMentas(List<Menta> mentas) {
        this.mentas = mentas;
    }
    
    
}
