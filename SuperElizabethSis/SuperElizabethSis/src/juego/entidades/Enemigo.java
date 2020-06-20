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


    public Enemigo(double x, double y,double angulo, double escala, double velocidad, Image image) {
        this.x = x;
        this.y = y;
        this.angulo = angulo;
        this.escala = escala;
        this.velocidad = velocidad;
        this.image = image;

    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(image,x,y,angulo,escala);
    }

    /* Movimiento hacia izquierda */
    public void moverIzq() {
        this.x = this.x - velocidad;
        if(this.x < -100 ){
            this.x = Math.floor(Math.random()*(1500-1300+1)+1500);
        }
    }
    /* Se obtiene el rectángulo de colisión de la instancia */
    public Rectangle getBordes() {
        return new Rectangle((int)x,(int)y,110,90);
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
