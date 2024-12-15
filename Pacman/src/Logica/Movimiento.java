
package Logica;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Movimiento implements KeyListener {
    
    private final static int numeroTeclas = 120;
    private final boolean[] teclas = new boolean[numeroTeclas];
    
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean escape;
    
    public void actualizar() {
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        izquierda = teclas[KeyEvent.VK_A];
        derecha = teclas[KeyEvent.VK_D];
        escape = teclas[KeyEvent.VK_ESCAPE];
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyTyped(KeyEvent e) { 
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }

}
