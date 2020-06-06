package juego.entidades;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Poder {
    private double x;
    private double y;
    private final double SPEED = 0.9;
    private Image image;

    public Poder(double x, double y) {
        this.x = x;
        this.y = y;
        this.image = Herramientas.cargarImagen("fireball.gif");
    }

    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(image,x,y,0,0.1);

    }

    public void avanzar(){
        this.x = this.x + SPEED;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
