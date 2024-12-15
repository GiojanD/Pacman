package Objetos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public final class Paredes {

    private final int sizeX;
    private final int sizeY;
    private final int sizeC;
    private final int X;
    private final int Y;
    private final int[][] grid;

    public Paredes(int X, int Y) {

        this.X = X;
        this.Y = Y;
        this.sizeX = 19;
        this.sizeY = 21;
        this.sizeC = 20;

        int[][] grid = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 4, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 4, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1},
            {5, 5, 5, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 5, 5, 5},
            {1, 1, 1, 1, 0, 1, 0, 1, 1, 3, 1, 1, 0, 1, 0, 1, 1, 1, 1},
            {2, 0, 0, 0, 0, 0, 0, 1, 5, 5, 5, 1, 0, 0, 0, 0, 0, 0, 2},
            {1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1},
            {5, 5, 5, 1, 0, 1, 0, 0, 0, 5, 0, 0, 0, 1, 0, 1, 5, 5, 5},
            {1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
            {1, 4, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 4, 1},
            {1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

        this.grid = grid;
    }

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        int grosor = 1;
        BasicStroke grosor1 = new BasicStroke(grosor + 1);
        g2D.setStroke(grosor1);

        g2D.setColor(new Color(62, 39, 230));

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (grid[i][j] == 1) {
                    switch (j) {
                        case 0 -> {
                            g2D.drawLine(X + grosor + sizeC * j, Y + grosor + sizeC * i, X + grosor + sizeC * j, Y - grosor + sizeC * (i + 1));

                            if (grid[i][j + 1] != 1) {
                                g2D.drawLine(X - grosor + sizeC * (j + 1), Y + grosor + sizeC * i, X - grosor + sizeC * (j + 1), Y - grosor + sizeC * (i + 1));
                            }
                        }
                        case 18 -> {
                            g2D.drawLine(X - grosor + sizeC * (j + 1), Y + grosor + sizeC * i, X - grosor + sizeC * (j + 1), Y - grosor + sizeC * (i + 1));
                            if (grid[i][j - 1] != 1) {
                                g2D.drawLine(X + grosor + sizeC * j, Y + grosor + sizeC * i, X + grosor + sizeC * j, Y - grosor + sizeC * (i + 1));
                            }
                        }
                        default -> {
                            if (grid[i][j + 1] != 1) {
                                g2D.drawLine(X - grosor + sizeC * (j + 1), Y + grosor + sizeC * i, X - grosor + sizeC * (j + 1), Y - grosor + sizeC * (i + 1));
                            }
                            if (grid[i][j - 1] != 1) {
                                g2D.drawLine(X + grosor + sizeC * j, Y + grosor + sizeC * i, X + grosor + sizeC * j, Y - grosor + sizeC * (i + 1));
                            }
                        }
                    }

                    switch (i) {
                        case 0 -> {
                            g2D.drawLine(X + grosor + sizeC * j, Y + grosor + sizeC * i, X - grosor + sizeC * (j + 1), Y + grosor + sizeC * i);

                            if (grid[i + 1][j] != 1) {
                                g2D.drawLine(X + grosor + sizeC * j, Y - grosor + sizeC * (i + 1), X - grosor + sizeC * (j + 1), Y - grosor + sizeC * (i + 1));
                            }
                        }
                        case 20 -> {
                            g2D.drawLine(X + grosor + sizeC * j, Y - grosor + sizeC * (i + 1), X - grosor + sizeC * (j + 1), Y - grosor + sizeC * (i + 1));
                            if (grid[i - 1][j] != 1) {
                                g2D.drawLine(X + grosor + sizeC * j, Y + grosor + sizeC * i, X - grosor + sizeC * (j + 1), Y + grosor + sizeC * i);
                            }
                        }
                        default -> {
                            if (grid[i + 1][j] != 1) {
                                g2D.drawLine(X + grosor + sizeC * j, Y - grosor + sizeC * (i + 1), X - grosor + sizeC * (j + 1), Y - grosor + sizeC * (i + 1));
                            }
                            if (grid[i - 1][j] != 1) {
                                g2D.drawLine(X + grosor + sizeC * j, Y + grosor + sizeC * i, X - grosor + sizeC * (j + 1), Y + grosor + sizeC * i);
                            }
                        }
                    }
                } else if (grid[i][j] == 3) {
                    g2D.setColor(Color.yellow);
                    g2D.fill(new Rectangle2D.Float(X + sizeC * j, Y - 12*grosor + sizeC * (i + 1), sizeC,5*grosor));
                    g2D.fill(new Rectangle2D.Float());
                    g2D.setColor(new Color(62, 39, 230));
                }
            }
        }
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getSizeC() {
        return sizeC;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int[][] getGrid() {
        return grid;
    }
}
