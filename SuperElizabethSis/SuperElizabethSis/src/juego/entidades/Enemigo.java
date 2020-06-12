package juego.entidades;

import entorno.Entorno;

import java.awt.*;

public class Enemigo {

    private double x;
    private double y;
    private final double angulo;
    private double escala;
    private final double velocidad;
    private Image image;
    private final int nuevaPosicion;

    public Enemigo(double x, double y,double angulo, double escala, double velocidad, Image image) {
        this.x = x;
        this.y = y;
        this.angulo = angulo;
        this.escala = escala;
        this.velocidad = velocidad;
        this.image = image;
        nuevaPosicion = (int) x;
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(image,x,y,angulo,escala);
    }

    public void moverIzq() {
        this.x = this.x - velocidad;
        if(this.x < -100 ){
            this.x = 1500;

        }
    }

    public Rectangle getBorder() {
        return new Rectangle((int)x,(int)y,50,300);
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
