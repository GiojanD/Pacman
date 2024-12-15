
package Logica;

import Objetos.Fantasma;
import Objetos.Menta;
import Objetos.Pacman;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame implements Runnable {

    private static Thread thread;
    private Movimiento movimiento;
    private static boolean funcionando;
    public static JPanel panel;
    public static Interfaz interfaz;
    
    private static int fps = 0;
    private static int aps = 0;
    
    public static void main(String[] args) {
        Ventana pacman = new Ventana();
        pacman.iniciar();
    }
    
    private synchronized void iniciar() {
                        
        InitComponents();
        
        thread = new Thread(this,"Graficos");
        thread.start();
    }
    
     public void InitComponents(){
         
        BufferedImage dibujoAux = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
        Graphics g = dibujoAux.createGraphics();
        Graphics2D g2d = (Graphics2D)g;

        BasicStroke grosor1 = new BasicStroke(15);
        g2d.setStroke(grosor1);
        g2d.setColor(Color.yellow);
        g2d.fillArc(20, 20, 216, 216, 30, 300);
        g2d.setColor(Color.black);
        g2d.draw(new Arc2D.Float(20, 20, 216,216, 30, 300,Arc2D.PIE));
        
        this.setIconImage(dibujoAux);
         
        this.setFocusable(true);
        this.movimiento = new Movimiento();
        Ventana.panel = new JPanel();
        interfaz = new Interfaz(); 
        Ventana.funcionando = true;
        
        this.setResizable(false);
        this.setSize(475,550);
        this.add(panel);
        panel.add(interfaz);
        panel.setFocusable(false);
        panel.setBackground(Color.black);
 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(movimiento);
        
    }
    
    private synchronized void detener() {
        funcionando = false;
        
        try {
            thread.join();
        }
        catch (InterruptedException e) {
        }
    }
    
    public void actualizar() {
        fps++;
        aps++;
        movimiento.actualizar();
        interfaz.actualizar();
    }

    @Override
    public void run() {
        while(funcionando) {

        long tempInicio = System.nanoTime();
        long tempContador = System.nanoTime();
        long tempContador2 = System.nanoTime();
        
        final byte APS = 60;
        final long NS_segundo = 1000000000;
        final double iteraciones = NS_segundo/APS;
        long tempDif;
        
        double delta = 0;
        
        while(tempInicio > 0) {
            final long tempFinal = System.nanoTime();
            tempDif = tempFinal - tempInicio;
            
            tempInicio = tempFinal;
            delta += tempDif / iteraciones;
            
            while (delta >= 1) {
                delta--;
                actualizar();
            }
            
            if (System.nanoTime() - tempContador > NS_segundo) {
                this.setTitle("PACMAN || APS: "+aps+" || FPS: " +fps);
                fps = 0;
                aps = 0;
                Puntos.setTimer(Puntos.getTimer()+1);
                tempContador = System.nanoTime();
                Menta.color = (Menta.color == Color.white)?new Color(0,0,0,1):Color.white;
                
                if (Fantasma.isWeak() && interfaz.getC().isPause() == false) {
                    Fantasma.weakTimer++;
                }
            }
            
            if (System.nanoTime() - tempContador2 > NS_segundo/3) {
                tempContador2 = System.nanoTime();
                Menta.color = (Menta.color == Color.white)?new Color(0,0,0,1):Color.white;
            }
        }
    }
    }
}
