package juego.entidades;

import entorno.Entorno;

import java.awt.*;

public class Poder {

    private double x;
    private double y;
    private double angulo;
    private double escala;
    private final double velocidad;
    private final Image image;

    public Poder(double x, double y, double angulo, double escala, double velocidad, Image image) {
        this.x = x;
        this.y = y;
        this.angulo = angulo;
        this.escala = escala;
        this.velocidad = velocidad;
        this.image = image;
    }

    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(image,x,y,angulo,escala);
    }

    //Metodo que hace avanzar a poder.
    public void avanzar(){
        if(getX() > 850) {
            setY(-20);
        }
        setX(getX() + velocidad);
    }

    /* Se verifica si la instancia colisiona con otra */
    public boolean colision(Rectangle objeto) {
        return objeto.intersects(getBordes());
    }

    /* Se obtiene el rectángulo de colisión de la instancia */
    public Rectangle getBordes() {
        return new Rectangle((int)x,(int)y,10,20);
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        if(x > 0 && x < 900) {
            this.x = x;
        } else {
            throw new RuntimeException("La posicion de x de Poder debe ser entre 0 y 900");
        }

    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if(y > -25 && y < 700) {
            this.y = y;
        } else {
            throw new RuntimeException("La posicion en Y debe ser entre -25 y 700");
        }
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public double getEscala() {
        return escala;
    }

    public void setEscala(double escala) {
        this.escala = escala;
    }

}
