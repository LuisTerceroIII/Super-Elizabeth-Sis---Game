package juego.entidades;

import entorno.Entorno;

import java.awt.*;

public class Obstaculo {
    private double x;
    private double y;
    private double angulo;
    private double escala;
    private Image image;
    private double velocidad;

    public Obstaculo(double x,double y,double angulo, double escala,double velocidad, Image image) {
        this.x = x;
        this.y = y;
        this.angulo = angulo;
        this.escala = escala;
        this.velocidad = velocidad;
        this.image = image;
    }


    public void dibujarse(Entorno entorno) {
        entorno.dibujarImagen(this.image,x,y,angulo,escala);

    }
    /* Movimiento hacia izquierda */
    public void moverIzq() {
        setX(getX()-velocidad);
        if(getX() < -40 ){
            setX(1000);
        }
    }

    /* Se obtiene el rectángulo de colisión de la instancia */
    public Rectangle getBordes() {
        return new Rectangle((int)x,(int)y,60,80);
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        if(x > -50 && x < 5000) {
            this.x = x;
        } else {
            throw new RuntimeException("Obstaculo no debe tener un posicion en X menor a -50 o mayor a 5000");
        }

    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if(y > -20 && y < 700){
            this.y = y;
        } else {
            throw new RuntimeException("Obstaculo no debe tener un posicion en Y menor a -20 o mayor a 700");
        }

    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }



}
