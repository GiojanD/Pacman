package Logica;

import Objetos.Pacman;
import Objetos.Fantasma;
import Objetos.Paredes;
import java.awt.*;

public class Interfaz extends Canvas {

    private static Pacman c;
    private Paredes paredes;
    private Fantasma Blinky;
    private Fantasma Inky;
    private Fantasma Pinky;
    private Fantasma Clyde;
    private Puntos puntos;

    private Image dibujoAux;
    private Graphics gAux;
    private Dimension dimAux;
    private Dimension dimCanvas;

    public Interfaz() {
        InitComponents();
    }

    public void InitComponents() {
        this.setFocusable(false);
        this.setSize(475, 500);
        dimCanvas = this.getSize();
        this.paredes = new Paredes(45, 60);
        this.puntos = new Puntos(this.paredes.getGrid(),paredes.getX(),paredes.getY(),paredes.getSizeC());
        Blinky = new Fantasma(225, 240, 17, 17, Color.red);
        Inky = new Fantasma(225, 240, 17, 17, Color.cyan);
        Pinky = new Fantasma(225, 240, 17, 17, Color.pink);
        Clyde = new Fantasma(225, 240, 17, 17, Color.orange);
        c = new Pacman(227, 281, 17);
    }

    public void actualizar() {
        if (!getC().isPause()) {
            this.getBlinky().update(this.getParedes(), Interfaz.getC().getX(), Interfaz.getC().getY());
            this.getInky().update(this.getParedes(), Interfaz.getC().getX(), Interfaz.getC().getY());
            this.getPinky().update(this.getParedes(), Interfaz.getC().getX(), Interfaz.getC().getY());
            this.getClyde().update(this.getParedes(), Interfaz.getC().getX(), Interfaz.getC().getY());

            this.repaint();
        }

    }

    @Override
    public void update(Graphics g) {
        this.paint(g);
    }

    @Override
    public void paint(Graphics g) {
        if (gAux == null || dimAux == null || dimCanvas.width != dimAux.width || dimCanvas.height != dimAux.height) {
            dimAux = dimCanvas;
            dibujoAux = createImage(dimAux.width, dimAux.height);
            gAux = dibujoAux.getGraphics();
        }
        super.paint(gAux);

        puntos.paint(gAux);

        Blinky.paint(gAux);
        Inky.paint(gAux);
        Pinky.paint(gAux);
        Clyde.paint(gAux);
        c.paint(gAux);
        paredes.paint(gAux);
        //grid.paint(gAux);

        g.drawImage(dibujoAux, 0, 0, this);

    }

    public static Pacman getC() {
        return c;
    }

    public static void setC(Pacman c) {
        Interfaz.c = c;
    }

    public Paredes getParedes() {
        return paredes;
    }

    public void setParedes(Paredes paredes) {
        this.paredes = paredes;
    }

    public Fantasma getBlinky() {
        return Blinky;
    }

    public void setBlinky(Fantasma Blinky) {
        this.Blinky = Blinky;
    }

    public Puntos getPuntos() {
        return puntos;
    }

    public void setPuntos(Puntos puntos) {
        this.puntos = puntos;
    }

    public Fantasma getInky() {
        return Inky;
    }

    public void setInky(Fantasma Inky) {
        this.Inky = Inky;
    }

    public Fantasma getPinky() {
        return Pinky;
    }

    public void setPinky(Fantasma Pinky) {
        this.Pinky = Pinky;
    }

    public Fantasma getClyde() {
        return Clyde;
    }

    public void setClyde(Fantasma Clyde) {
        this.Clyde = Clyde;
    }

    public Image getDibujoAux() {
        return dibujoAux;
    }

    public void setDibujoAux(Image dibujoAux) {
        this.dibujoAux = dibujoAux;
    }

    public Graphics getgAux() {
        return gAux;
    }

    public void setgAux(Graphics gAux) {
        this.gAux = gAux;
    }

    public Dimension getDimAux() {
        return dimAux;
    }

    public void setDimAux(Dimension dimAux) {
        this.dimAux = dimAux;
    }

    public Dimension getDimCanvas() {
        return dimCanvas;
    }

    public void setDimCanvas(Dimension dimCanvas) {
        this.dimCanvas = dimCanvas;
    }

}
