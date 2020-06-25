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
        setX(getX() - velocidad);
        if(getX() < -100 ){
            setX(Math.floor(Math.random()*(1500-1300+1)+1500));
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
        if(x > -150 && x < 5000) {
            this.x = x;
        } else {
            throw new RuntimeException("Enemigo no debe tener un posicion en X menor a -150 o mayor a 5000");
        }

    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if(y > -100 && y < 700){
            this.y = y;
        } else {
            throw new RuntimeException("Enemigo no debe tener un posicion en Y menor a -20 o mayor a 700");
        }
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
