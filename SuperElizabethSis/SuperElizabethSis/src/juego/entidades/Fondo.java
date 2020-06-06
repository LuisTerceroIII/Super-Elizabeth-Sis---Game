package juego.entidades;

import entorno.Entorno;

import java.awt.*;

public class Fondo {

    private double x;
    private double y;
    private double escala;
    private Image image;

    public Fondo(Image image, double x, double y,double escala) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.escala = escala;
    }
    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(image,x,y,0);
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getEscala() {
        return escala;
    }

    public void setEscala(double escala) {
        this.escala = escala;
    }
}
