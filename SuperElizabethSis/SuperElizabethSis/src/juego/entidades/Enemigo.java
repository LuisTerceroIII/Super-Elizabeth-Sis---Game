package juego.entidades;

import entorno.Entorno;

import java.awt.*;

public class Enemigo {

    private double x;
    private double y;
    private double escala;
    private double velocidad;
    private Image image;

    public Enemigo(double x, double y, double escala, Image image, double velocidad) {
        this.x = x;
        this.y = y;
        this.escala = escala;
        this.image = image;
        this.velocidad = velocidad;
    }
    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(image,x,y,0,escala);
    }
    public void moverIzq() {
        this.x = this.x - velocidad;
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

    public double getEscala() {
        return escala;
    }

    public void setEscala(double escala) {
        this.escala = escala;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
