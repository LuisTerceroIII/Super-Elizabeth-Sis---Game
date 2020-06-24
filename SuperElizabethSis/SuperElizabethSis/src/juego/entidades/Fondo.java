package juego.entidades;

import entorno.Entorno;

import java.awt.*;

public class Fondo {

    private double x;
    private double y;
    private double escala;
    private double angulo;
    private Image image;


    public Fondo(double x, double y, double escala, double angulo, Image image) {
        this.x = x;
        this.y = y;
        this.escala = escala;
        this.angulo = angulo;
        this.image = image;
    }

    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(image,x,y,angulo);
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

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }
}
